package com.nyrta1.yamllibraryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class XmlLibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlLibraryServiceApplication.class, args);
	}

}
