package com.example.la.usuario;

import com.example.la.usuario.config.OpenApiConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes={MicroservicioUsuarioApplication.class, OpenApiConfiguration.class})
class MicroservicioUsuarioApplicationTests {

	@Test
	void contextLoads() {
	}

}
