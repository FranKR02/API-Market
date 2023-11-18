package projects.market.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConf {
    @Bean
    public OpenAPI myOpenApi(){
        Contact contact = new Contact();
        contact.setEmail("frankdiego007@hotmail.com");
        contact.setName("FranKR02");

        Info info = new Info()
                .title("Tutorial Management API Market")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials");

        return new OpenAPI().info(info);
    }
}
