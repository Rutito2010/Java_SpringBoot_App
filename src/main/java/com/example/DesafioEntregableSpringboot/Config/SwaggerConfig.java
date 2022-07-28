package com.example.DesafioEntregableSpringboot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;



    @Configuration

    public class SwaggerConfig {
        @Bean
        public Docket api(){

            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiDetails())
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build();

        }

        private ApiInfo apiDetails(){
            return new ApiInfo("Proyecto SpringBoot ApiRest",
                    "Proyecto SpringBoot",
                    "1.0",
                    "",
                    new Contact("Rutito","https://www.linkedin.com/in/passaliaivan/","passivan98@gmail.com"),
                    "license",
                    "www.googgle.com",
                    Collections.emptyList());
        }

    }

