package com.aws.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@RestController
public class RestControllerAWS {
	
	@Autowired
	private ServiceAWS serviceAWS;

	@Autowired
	private DynamoDbClient dynamoDbClient;
	
	@GetMapping("/create/dynamo/{tableName}")
	public List<String> createTableDynamo(@PathVariable String tableName) {
		serviceAWS.createTable(tableName);
		return dynamoDbClient.listTables().tableNames();
	}
}
