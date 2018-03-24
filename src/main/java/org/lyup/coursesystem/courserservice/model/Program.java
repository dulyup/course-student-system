package org.lyup.coursesystem.courserservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@DynamoDBTable(tableName = "Program")
public @Data
class Program {
	
	// Partition key
    @DynamoDBHashKey(attributeName = "program_id")
    private String programId;

    @DynamoDBAttribute(attributeName = "program_title")
    private String programTitle;

    @DynamoDBAttribute(attributeName = "course_set")
    private Set<String> courseSet = new HashSet<>();

}
