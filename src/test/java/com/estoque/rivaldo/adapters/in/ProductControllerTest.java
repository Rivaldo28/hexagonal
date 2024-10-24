package com.estoque.rivaldo.adapters.in;

import com.estoque.rivaldo.application.ports.input.ProductInputPort;
import com.estoque.rivaldo.domain.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductInputPort productInputPort; // Use @MockBean para simular a porta de entrada

    @Test
    public void testGetAllProducts() throws Exception {
        Product product = new Product(1L, "Product1", 10);
        when(productInputPort.findAll()).thenReturn(Collections.singletonList(product));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Product1"));
    }

    @Test
    public void testCreateProduct() throws Exception {
        Product product = new Product(1L, "Product1", 10);
        when(productInputPort.createProduct(any())).thenReturn(product);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Product1\", \"quantity\":10}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Product1"));
    }
}