package com.estoque.rivaldo.application.services;

import com.estoque.rivaldo.application.ports.output.ProductOutputPort;
import com.estoque.rivaldo.domain.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductOutputPort productOutputPort;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(1L, "Product1", 10));

        when(productOutputPort.findAll()).thenReturn(expectedProducts);

        List<Product> products = productService.findAll();

        assertEquals(1, products.size());
        assertEquals("Product1", products.get(0).getName());
    }
}