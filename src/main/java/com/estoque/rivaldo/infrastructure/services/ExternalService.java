package com.estoque.rivaldo.infrastructure.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {
//    private static final Logger logger = LoggerFactory.getLogger(ExternalService.class);
//    private final RestTemplate restTemplate;

    // Injeção de dependência via construtor
//    public ExternalService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    /**
     * Faz uma chamada a uma API externa e retorna os dados.
     *
     * //@param apiUrl URL da API externa.
     * //@return Resposta da API como String, ou null em caso de erro.
     */
//    public String fetchDataFromExternalApi(String apiUrl) {
//        try {
//            return restTemplate.getForObject(apiUrl, String.class);
//        } catch (Exception e) {
            // Loga o erro em vez de imprimir no console
//            logger.error("Erro ao chamar a API externa: {}", e.getMessage());
//            return null; // Retorna null em caso de erro
//        }
//    }
}