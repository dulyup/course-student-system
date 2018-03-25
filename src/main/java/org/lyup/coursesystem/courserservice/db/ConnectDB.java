package org.lyup.coursesystem.courserservice.db;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.util.TableUtils;

public class ConnectDB {

	private static AmazonDynamoDB client = init();
    public static DynamoDB dynamoDB = new DynamoDB(client);
    public static DynamoDBMapper getMapper = new DynamoDBMapper(client);

    /**
     * Method creates a DynamoDb object
     *
     */
    private static AmazonDynamoDB init() {
        try {
            ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
            credentialsProvider.getCredentials();
            client = AmazonDynamoDBClientBuilder
                    .standard()
                    .withCredentials(credentialsProvider)
                    .withRegion("us-west-2")
                    .build(); //return dynamoDB
        }catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    public static void createTable(String tableName, String partitionKey) {
        try {
            CreateTableRequest createTableRequest = new CreateTableRequest();
            createTableRequest.withTableName(tableName)
                .withKeySchema(
                        new KeySchemaElement()
                                .withAttributeName(partitionKey)
                                .withKeyType(KeyType.HASH))
                .withAttributeDefinitions(
                        new AttributeDefinition()
                                .withAttributeName(partitionKey)
                                .withAttributeType(ScalarAttributeType.S))
                .withProvisionedThroughput(
                        new ProvisionedThroughput()
                                .withReadCapacityUnits(3L)
                                .withWriteCapacityUnits(3L));
            TableUtils.createTableIfNotExists(client, createTableRequest);
            TableUtils.waitUntilActive(client, tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Table getTableByName(String tableName) {
    		return dynamoDB.getTable(tableName);
    }
}
