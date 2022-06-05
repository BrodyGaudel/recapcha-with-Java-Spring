package com.brody.recaptcha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * It is just to create RestTemplate object. 
 * Further we will need a Rest Consumer call in the next Validator class.
 * @author brody
 *
 */

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
