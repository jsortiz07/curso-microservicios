package com.usuarioservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	
	// esta clase nos ayuda a comunicar nuestros servicios
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
