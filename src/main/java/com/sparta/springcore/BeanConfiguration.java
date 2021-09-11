package com.sparta.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 처음에 스프링이 기동될 때, 해당 클래스를 바라보고
                // @Bean으로 되어있는 함수들을 살펴보고 필요한 내용들을 Bean으로 담음
public class BeanConfiguration {
    @Bean
    public ProductRepository productRepository() {
        String dbId = "sa";
        String dbPassword = "";
        String dbUrl = "jdbc:h2:mem:springcoredb";
        return new ProductRepository(dbId, dbPassword, dbUrl);
    }

    @Bean
    @Autowired
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}