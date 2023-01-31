package com.corinto.libraryapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableWebMvc
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.corinto.libraryapi.api.resource"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiInfoMetaData());
    }

//    @Bean
//    public Docket docket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis( RequestHandlerSelectors.basePackage("com.corinto.libraryapi.api.resource") )
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }

    private ApiInfo apiInfoMetaData() {

        return new ApiInfoBuilder().title("Library API")
                .description("API do Projeto de controle de aluguel de livros")
                .contact(new Contact("fhoc", "http://github.com/fhocfhoc", "backintheusa@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("Library API")
//                .description("API do Projeto de controle de aluguel de livros")
//                .version("1.0")
//                .contact(contact())
//                .build();
//    }
//
//    private Contact contact(){
//        return new Contact("Fernando H. Costa",
//                "http://github.com/fhocfhoc",
//                "backintheusa@gmail.com");
//    }
}