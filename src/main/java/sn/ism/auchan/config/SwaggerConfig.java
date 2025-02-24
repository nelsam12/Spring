package sn.ism.auchan.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SwaggerConfig {
    @Value("${spring.application.version}")
    private String version ;
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Gestion Article API")
                .version(version)
                .description("API pour gérer une boutique en ligne"));
    }

//    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi
                .builder()
                .group("Gestion Auchan")
//                .packagesToScan("sn.ism.auchan.web.controllers")
//                .packagesToExclude("sn.ism.auchan.data.entities")
                .build();
    }
}

/*
================
Exception
Redis
Security
================
*/
