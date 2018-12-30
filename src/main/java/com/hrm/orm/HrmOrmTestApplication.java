package com.hrm.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HrmOrmTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmOrmTestApplication.class, args);
	}
}
