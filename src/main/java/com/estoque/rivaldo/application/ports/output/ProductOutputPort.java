package com.estoque.rivaldo.application.ports.output;

import com.estoque.rivaldo.domain.models.Product;

import java.util.List;

public interface ProductOutputPort {
    List<Product> findAll();
    Product save(Product product);
}
