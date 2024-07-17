package com.avanse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude= {PersistenceElmsAutoConfiguration.class})
@SpringBootApplication
public class ElmsPennantViewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElmsPennantViewsApplication.class, args);
	}

}
