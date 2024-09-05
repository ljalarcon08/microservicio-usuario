package com.example.la.usuario.config;

import java.util.List;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@OpenAPIDefinition
@SecurityScheme(
		name = "Bearer Authentication",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
)
@Configuration
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI userOpenAPI(@Value("${openapi.service.title}") String serviceTitle,
		      @Value("${openapi.service.version}") String serviceVersion) {
	    return new OpenAPI()
	            .servers(List.of(new Server().url(""),new Server().url("http://localhost:8090/api/usuario")))
	            .info(new Info().title(serviceTitle).version(serviceVersion));
	}
	
}
