package ru.studentsplatform.endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.studentsplatform.*"})
@EnableDiscoveryClient
@EnableZuulProxy
public class EndpointApplication {
	public static void main(String[] args) {
		SpringApplication.run(EndpointApplication.class, args);
	}
}
