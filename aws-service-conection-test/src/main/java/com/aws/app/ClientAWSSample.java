package com.aws.app;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class ClientAWSSample {
	
	@Bean
	DynamoDbClient dynamoDbClient() {
		return DynamoDbClient.create();
	}
	
	@Bean
	ApplicationRunner applicationRunner(DynamoDbClient dynamoDbClient) {
		return arg -> {
			dynamoDbClient.listTables().tableNames()
			.forEach(System.out::println);
		};
	}
}
