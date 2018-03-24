package org.lyup.coursesystem.courserservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

import java.util.Set;

@DynamoDBTable(tableName = "Professor")
public @Data
class Professor {

    // Partition key
    @DynamoDBHashKey(attributeName = "prof_id")
    private String profId;

    @DynamoDBAttribute(attributeName = "p_first_name")
    private String pFirstName;

    @DynamoDBAttribute(attributeName = "p_last_name")
    private String pLastName;

    @DynamoDBAttribute(attributeName = "email")
    private String email;

    @DynamoDBAttribute(attributeName = "course_id")
    private Set<String> courseId;

}
