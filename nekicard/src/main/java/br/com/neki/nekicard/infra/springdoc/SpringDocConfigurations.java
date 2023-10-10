package br.com.neki.nekicard.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Neki.card API")
                        .description(
                                "API Rest da aplicação Neki.card, contendo as funcionalidades de CRUD de Perfis")
                        .contact(new Contact()
                                .name("Gustavo Mariano")
                                .email("gustavomariano2001@hotmail.com")
                                .url("https://github.com/GustavMariano")));
    }
}
