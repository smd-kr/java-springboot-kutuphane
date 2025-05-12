package com.kutuphane.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.kutuphane"}) 
@SpringBootApplication
public class KutuphaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(KutuphaneApplication.class, args);
	}

}
