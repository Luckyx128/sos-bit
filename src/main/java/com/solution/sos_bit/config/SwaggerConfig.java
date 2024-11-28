package com.solution.sos_bit.config;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    private static final String SECURITY_SCHEME_NAME = "Bearer Authentication";
    private static ExternalDocumentation gitHubLink;
    private static Info infos;

    private static void setGitHubLink() {
        gitHubLink = new ExternalDocumentation()
                .description("GitHub Link")
                .url("https://github.com/Luckyx128/sos-bit");
    }

    private static void setInfos() {
        infos = new Info()
                .title("Api")
                .version("1.0");
    }

    private SecurityScheme createSecurityScheme() {
        return new SecurityScheme()
                .name(SECURITY_SCHEME_NAME)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .description("""
                    Informe o token JWT para autenticação.
                    
                    Como obter o token:
                    1. Faça login através da rota /auth/login
                    2. Copie o token retornado
                    3. Clique no botão 'Authorize' acima
                    4. Cole o token no campo 'Value' (sem a palavra 'Bearer')
                    5. Clique em 'Authorize' e depois em 'Close'
                    """);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        setGitHubLink();
        setInfos();

        return new OpenAPI()
                .info(infos)
                .externalDocs(gitHubLink)
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components().addSecuritySchemes(SECURITY_SCHEME_NAME, createSecurityScheme()));
    }
}