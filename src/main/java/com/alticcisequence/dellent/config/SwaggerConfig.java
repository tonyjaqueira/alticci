package com.alticcisequence.dellent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    public static final String ALTICCI = "Alticci Controller";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/alticci/*"))
                .build()
                .enableUrlTemplating(true)
                .apiInfo(apiInfo())
                .tags(new Tag(ALTICCI, "Controlador para obtenção de sequência alticci."));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("REST API Alticci")
                .description("API de teste para cálculo de sequencia Alticci")
                .version("1.0.0")
                .contact(new Contact("Antônio Araujo", "https://github.com/tonyjaqueira", "tonyjaqueira@hotmail.com"))
                .build();
    }

}
