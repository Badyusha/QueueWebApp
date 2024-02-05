package com.QueueWebApp;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class QueueWebAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(QueueWebAppApplication.class, args);
	}
}