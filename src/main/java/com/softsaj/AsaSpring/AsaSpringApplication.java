package com.softsaj.AsaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.softsaj.AsaSpring.security"})
@ComponentScan({"com.softsaj.AsaSpring.exception"})
@ComponentScan({"com.softsaj.AsaSpring.models"})
@ComponentScan({"com.softsaj.AsaSpring.repositories"})
@ComponentScan({"com.softsaj.AsaSpring.resource"})
@ComponentScan({"com.softsaj.AsaSpring.services"})
public class AsaSpringApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(AsaSpringApplication.class, args);
	}

}
