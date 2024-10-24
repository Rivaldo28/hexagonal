package com.estoque.rivaldo.application.ports.input;

import com.estoque.rivaldo.domain.models.Product;

import java.util.List;

public interface ProductInputPort {
    List<Product> findAll();
    Product createProduct(Product product);
}
