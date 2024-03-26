package com.test.javacourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JavacourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavacourseApplication.class, args);
	}

}
