package com.piliugin.tacocloud.config;

import com.piliugin.tacocloud.repository.IngredientRepository;
import com.piliugin.tacocloud.repository.JdbcIngredientRepository;
import com.piliugin.tacocloud.repository.JdbcOrderRepository;
import com.piliugin.tacocloud.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class TacoCloudConfig {

    @Bean
    public IngredientRepository ingredientRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcIngredientRepository(jdbcTemplate);
    }

    @Bean
    public OrderRepository orderRepository(JdbcOperations jdbcOperations) {
        return new JdbcOrderRepository(jdbcOperations);
    }

}
