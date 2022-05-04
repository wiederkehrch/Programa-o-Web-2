package br.com.senac.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


/* Swagger
 http://localhost:8080/api-sistema/swagger-ui/index.html#/
 

@Configuration
public class SwaggerConfig {
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.description}")
	private String appDescription;
	
	@Value("${app.version}")
	private String appVersion;
	
	
	public OpenAPI openApi() {
		
		return new OpenAPI()
				.info(new Info()
				.title(appName)
				.description(appDescription)
				.version(appVersion));
		
	}

}

*
*
-------------- application.properties do Swagger --------------

app.name = @project.name@
app.description = @project.description@
app.version = @project.version@

springdoc.api-docs.path=/api-docs

server.servlet.context-path=/api-sistema

*/
