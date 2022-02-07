package com.example.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogServiceApplication {

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(3000);
		return new RestTemplate(httpComponentsClientHttpRequestFactory);
	}
//	@Bean
//	public WebClient.Builder getWebClientBuilder(){
//		return WebClient.builder();
//	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
