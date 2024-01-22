package com.nyrta1.libraryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JsonLibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonLibraryServiceApplication.class, args);
	}

}
