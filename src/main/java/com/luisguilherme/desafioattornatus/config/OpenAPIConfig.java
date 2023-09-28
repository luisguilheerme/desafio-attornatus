package com.luisguilherme.desafioattornatus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition
@Configuration
public class OpenAPIConfig {

	@OpenAPIDefinition
	@Configuration
	public class OpenApiConfig {

		@Bean
		public OpenAPI dsmovieAPI() {
			return new OpenAPI()
					.info(new Info()
					.title("Desafio Attornatus")
					.description("Desafio Backend Java para processo seletivo da empresa Attornatus.")
					.version("v0.0.1")
					.license(new License()
					.name("Apache 2.0")
					.url("https://github.com/luisguilheerme/desafio-attornatus")));
		}
	}

}
