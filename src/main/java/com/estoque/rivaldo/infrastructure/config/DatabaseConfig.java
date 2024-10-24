package com.estoque.rivaldo.infrastructure.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = "com.estoque.rivaldo.adapters.out")
public class DatabaseConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        // Altere a URL, usuário e senha para PostgreSQL se necessário
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1") // H2 em memória
                // Para PostgreSQL, utilize:
                // .url("jdbc:postgresql://localhost:5432/seu_banco_de_dados")
                // .username("seu_usuario")
                // .password("sua_senha")
                .username("sa")
                .password("")
                .driverClassName("org.h2.Driver") // H2 Driver
                // Para PostgreSQL, utilize:
                // .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.estoque.rivaldo.domain.models");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update"); // Para atualizar o esquema do banco
        properties.put("hibernate.show_sql", true); // Para mostrar as consultas SQL no console
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); // Dialeto para H2
        // Para PostgreSQL, descomente a linha abaixo:
        // properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}