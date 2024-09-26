package com.grupo1software.youngmiracles.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerAPIConfig {

    @Value("${YoungMiracles.openapi.dev-url-http}")
    private String devUrl;


    @Bean
    public OpenAPI myOpenAPI(){
        Server devServer= new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Development Server");

        Contact contact= new Contact();
        contact.setEmail("renato.vivas2001@gmail.com");
        contact.setName("YoungMiracles");
        contact.setUrl("https://github.com/RenatoVA/YoungMiracles");

        License mitLicense=new License().name("MIT License").url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("API servicios youngmiracles")
                .version("1.0")
                .contact(contact)
                .description("API Restful de servicios youngmiracles")
                .termsOfService("https://github.com/RenatoVA/YoungMiracles")
                .license(mitLicense);
        return new OpenAPI()
                .info(info)
                .addServersItem(devServer);


    }

}
