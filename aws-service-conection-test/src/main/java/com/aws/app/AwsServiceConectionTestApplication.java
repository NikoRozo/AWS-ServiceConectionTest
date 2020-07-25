package com.aws.app;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;


@SpringBootApplication
public class AwsServiceConectionTestApplication {

	static final String endpointOverride = "http://localhost";
	
	
	public static void main(String[] args) {
		SpringApplication.run(AwsServiceConectionTestApplication.class, args);
	}
	
	@Bean
	DynamoDbClient dynamoDbClient() {
		return DynamoDbClient.create();
	}
	
	@Bean
	ApplicationRunner applicationRunner(DynamoDbClient dynamoDbClient) {
		return args -> {
			dynamoDbClient.listTables().tableNames()
			.forEach(System.out::println);
		};
	}
}
