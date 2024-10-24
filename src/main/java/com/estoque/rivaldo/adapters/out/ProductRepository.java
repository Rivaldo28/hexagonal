package com.estoque.rivaldo.adapters.out;

import com.estoque.rivaldo.application.ports.output.ProductOutputPort;
import com.estoque.rivaldo.domain.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository implements ProductOutputPort {
    private final List<Product> products = new ArrayList<>();
    private final Set<String> productNames = new HashSet<>(); // Para verificar unicidade
    private final AtomicLong idCounter = new AtomicLong(); // Para gerar IDs únicos

    @Override
    public List<Product> findAll() {
        return products; // Retorna a lista de produtos
    }

    @Override
    public Product save(Product product) {
        // Verifica se o nome já existe
        if (productNames.contains(product.getName())) {
            throw new IllegalArgumentException("o usuário comeu bola!"); // Lança uma exceção se o nome já existir
        }

        // Gera um novo ID
        product.setId(idCounter.incrementAndGet());
        // Adiciona o nome ao conjunto e o produto à lista
        productNames.add(product.getName());
        products.add(product); // Adiciona o produto à lista
        return product; // Retorna o produto com o ID gerado
    }
}