package com.paymenttransaction.payment_transaction_manager.config.openapi;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Payment Transaction Manager API")
                        .version("1.0.0")
                        .description("Documentación de las APIs para el manejo de transacciones financieras"));
    }
}
