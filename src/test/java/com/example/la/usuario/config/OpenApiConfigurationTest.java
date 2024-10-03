package com.example.la.usuario.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class OpenApiConfigurationTest {

    @Test
    public void userOpenAPITest(){
        OpenApiConfiguration openApiConfiguration=new OpenApiConfiguration();
        OpenAPI openAPI=openApiConfiguration.userOpenAPI("title","version");
        Assert.notNull(openAPI,"error");
    }
}
