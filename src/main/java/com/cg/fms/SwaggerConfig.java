package com.cg.fms;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("product-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/products/.*"),regex("/customers/.*"),regex("/cart/.*"),regex("/contract/.*"),regex("/orders/.*"),regex("/contracts/.*"),regex("/schedulers/.*"),regex("/admins/.*"),regex("/lands/.*"),regex("/registration/.*"));
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Forestry Management System API").description("API reference for developers")
				.termsOfServiceUrl("http://RAJ.com").license("Product License").licenseUrl("raJ@gmail.com")
				.version("1.0").build();
	}

}