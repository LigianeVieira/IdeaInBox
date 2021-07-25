package com.IdeaBox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class IdeaboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeaboxApplication.class, args);
	}

}
