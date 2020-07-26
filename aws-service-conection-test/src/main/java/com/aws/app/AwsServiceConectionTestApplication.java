package com.aws.app;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.aws.app.config.DynamoProperties;

import software.amazon.awssdk.awscore.client.builder.AwsClientBuilder;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.s3.S3Client;


@SpringBootApplication
@EnableConfigurationProperties(DynamoProperties.class)
public class AwsServiceConectionTestApplication {
	//@Autowired
	//private ServiceAWS serviceAWS;
	
	public static void main(String[] args) {
		SpringApplication.run(AwsServiceConectionTestApplication.class, args);
	}
	
	@Bean
	DynamoDbClient dynamoDbClient(DynamoProperties dynamoProperties) {
		return apply(dynamoProperties, DynamoDbClient.builder()).build();
	}
	
	@Bean
	S3Client s3Client(DynamoProperties dynamoProperties) {
		return apply(dynamoProperties, S3Client.builder()).build();
	}
	
	public <BuilderT extends AwsClientBuilder<BuilderT, ClientT>, ClientT> AwsClientBuilder<BuilderT, ClientT> apply (DynamoProperties dynamoProperties, AwsClientBuilder<BuilderT, ClientT> builder){
		
		if (dynamoProperties.getEndpointURI() != null) {
			builder.endpointOverride(dynamoProperties.getEndpointURI());			
		}
		return builder;
	}
	
	@Bean
	ApplicationRunner applicationRunner(DynamoDbClient dynamoDbClient) {
		return args -> {
			//serviceAWS.createTable("Book");;
			System.out.println("Star");
		};
	}
	
}
