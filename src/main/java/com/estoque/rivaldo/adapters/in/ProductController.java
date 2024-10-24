package com.estoque.rivaldo.adapters.in;

import com.estoque.rivaldo.application.ports.input.ProductInputPort;


import com.estoque.rivaldo.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductInputPort productInputPort;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productInputPort.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) {
        Product createdProduct = productInputPort.createProduct(product);
        System.out.println("Produto criado: " + createdProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
}
