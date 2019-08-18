package com.sandrohc2010.escolarsbapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EscolarsbapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolarsbapiApplication.class, args);
	}

}
