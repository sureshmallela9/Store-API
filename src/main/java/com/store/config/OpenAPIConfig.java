package com.store.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Store API")
                        .version("1.0.0")
                        .description("REST API for managing products in an online store")
                        .contact(new Contact()
                                .name("Store Team")
                                .email("support@store.com")));
    }
}

