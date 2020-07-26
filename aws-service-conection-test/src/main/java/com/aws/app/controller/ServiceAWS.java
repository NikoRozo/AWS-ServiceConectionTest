package com.aws.app.controller;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;

@Service
public class ServiceAWS {
	private final DynamoDbClient dynamoDbClient;
	
	public ServiceAWS(DynamoDbClient dynamoDbClient) {
		this.dynamoDbClient = dynamoDbClient;
	}
	
	void createTable(String name) {
		dynamoDbClient.listTables().tableNames()
		.forEach(System.out::println);
		
		dynamoDbClient.listTables().tableNames()
		.forEach(System.out::println);
		CreateTableRequest createtable =
				CreateTableRequest.builder()
				.tableName(name)
				.keySchema(KeySchemaElement.builder()
						.keyType(KeyType.HASH)
						.attributeName("id")
						.build())
				.attributeDefinitions(AttributeDefinition.builder()
						.attributeName("id")
						.attributeType(ScalarAttributeType.S)
						.build())
				.provisionedThroughput(ProvisionedThroughput.builder()
						.writeCapacityUnits(5L)
						.readCapacityUnits(5L)
						.build())
				.build();
		dynamoDbClient.createTable(createtable);
		
		dynamoDbClient.listTables().tableNames()
		.forEach(System.out::println);
	}
}
