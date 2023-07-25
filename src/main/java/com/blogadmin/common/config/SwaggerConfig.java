package com.blogadmin.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

//
@Configuration
@EnableSwagger2
//@EnableWebMvc
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.blogadmin")).build();
	}

//	@Bean
//	CorsConfigurationSource corsConfigurationSource()
//	{
//
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.addAllowedOriginPattern("*");
////       configuration.addAllowedOrigin(corsOrigin);
//		configuration.addAllowedHeader("Content-Type");
//		configuration.addAllowedHeader("Authorization");
//		configuration.addAllowedHeader("X-Requested-With");
//		configuration.addAllowedHeader("authorization");
//		configuration.addAllowedHeader("multipart/form-data");
//		configuration.setAllowCredentials(true);
//		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//		configuration.setMaxAge((long) 86400);
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
}
