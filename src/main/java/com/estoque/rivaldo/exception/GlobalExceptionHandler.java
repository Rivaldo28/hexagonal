package com.estoque.rivaldo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class) // Captura IllegalArgumentException
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Erro: " + ex.getMessage()); // Mensagem para o usuário
        response.put("developerMessage", ex.toString()); // Mensagem para o desenvolvedor
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response); // Retorna 409 em caso de conflito
    }

    @ExceptionHandler(Exception.class) // Captura outras exceções
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "O produto deve ser único. Por favor, tente novamente."); // Mensagem para o usuário
        response.put("developerMessage", ex.toString()); // Mensagem para o desenvolvedor
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // Retorna 500 para erro interno
    }
}
