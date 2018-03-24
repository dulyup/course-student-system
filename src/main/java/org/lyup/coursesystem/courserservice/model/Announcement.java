package org.lyup.coursesystem.courserservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@DynamoDBTable(tableName = "Announcement")
public @Data
class Announcement {

    // Partition key
    @DynamoDBHashKey(attributeName = "an_id")
    private String anId;

    @DynamoDBAttribute(attributeName = "message")
    private String message;

    @DynamoDBAttribute(attributeName = "course_id")
    private String courseId;

}
