package com.estoque.rivaldo.application.services;

import com.estoque.rivaldo.application.ports.input.ProductInputPort;
import com.estoque.rivaldo.application.ports.output.ProductOutputPort;
import com.estoque.rivaldo.domain.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductInputPort {
    private final ProductOutputPort productOutputPort;

    public ProductService(ProductOutputPort productOutputPort) {
        this.productOutputPort = productOutputPort;
    }

    @Override
    public List<Product> findAll() {
        return productOutputPort.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        // Salva o produto e captura o objeto retornado com o ID gerado
        Product savedProduct = productOutputPort.save(product);
        return savedProduct; // Retorna o produto salvo com o ID gerado
    }
}
