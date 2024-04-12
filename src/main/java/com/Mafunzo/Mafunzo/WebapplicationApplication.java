package com.Mafunzo.Mafunzo;

import Controller.ActivityController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class} )
public class WebapplicationApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebapplicationApplication.class, args);
	}

}
