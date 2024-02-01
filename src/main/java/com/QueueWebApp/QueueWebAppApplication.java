package com.QueueWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class QueueWebAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(QueueWebAppApplication.class, args);
		// here can be closing resources
	}
}
