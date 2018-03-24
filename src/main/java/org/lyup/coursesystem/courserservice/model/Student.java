package org.lyup.coursesystem.courserservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@DynamoDBTable(tableName = "Student")
public @Data
class Student {

	// Partition key
    @DynamoDBHashKey(attributeName = "stu_id")
    private String stuId;

    @DynamoDBAttribute(attributeName = "first_name")
    private String firstName;

    @DynamoDBAttribute(attributeName = "last_name")
    private String lastName;

    @DynamoDBAttribute(attributeName = "email")
    private String email;

    @DynamoDBAttribute(attributeName = "image")
    private String image;

    @DynamoDBAttribute(attributeName = "program_id")
    private String programId;

    @DynamoDBAttribute(attributeName = "course_set")
    private Set<String> courseSet = new HashSet<>();
    
}
