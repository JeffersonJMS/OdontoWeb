package br.com.odontoWeb.config.swaager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean 
	public Docket odontoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Odonto Web")
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.odontoWeb"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(infoApi());
	}

	private ApiInfo infoApi() {
		return new ApiInfoBuilder()
				.title("Odonto Web API")
				.description("\"Sistema elaborado para clínica odontológica, fornecendo registro de prontuários para futuros acompanhamentos\"")
				.version("1.0")
				.license("Licença - Open Source")
				.licenseUrl("")
				.contact(contato())
				.build();
	}
	
	private Contact contato() {
		return new Contact("Jefferson Miranda", "https://github.com/JeffersonJMS", "jeffersonmiranda49@gmail.com");
	}
}