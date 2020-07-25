package com.aws.app;

import java.net.URI;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("dynamo")
@Data
public class DynamoProperties {
	private URI endpointURI;
	
}
