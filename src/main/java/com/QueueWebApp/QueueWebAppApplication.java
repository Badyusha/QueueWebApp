package com.QueueWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class QueueWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueWebAppApplication.class, args);
	}

}