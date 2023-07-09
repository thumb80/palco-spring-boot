package com.thumb.palco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
@EnableAutoConfiguration
public class PalcoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalcoApplication.class, args);
	}

	public class mvcConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			CorsRegistry reg = registry;
			reg.addMapping("/getconcertitime/{time}").allowedOrigins("https://palco.mywire.org");
			WebMvcConfigurer.super.addCorsMappings(reg);
		}
	}
}
