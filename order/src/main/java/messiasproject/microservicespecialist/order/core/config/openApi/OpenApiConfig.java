package messiasproject.microservicespecialist.order.core.config.openApi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Messias",
                        email = "messias.silva_dev@hotmail.com",
                        url = "https://www.linkedin.com/in/messias-dev-silva/"
                ),
                description = "OpenApi documentation for project Order",
                title = "OpenApi specification - Project Order Messias",
                version = "1"
        ),
        servers = {
                @Server(
                        description = "local server",
                        url = "http://localhost:8080/order"
                ),
                @Server(
                        description = "Eureka server",
                        url = "http://localhost:8761/"
                )
        }
)public class OpenApiConfig {
}
