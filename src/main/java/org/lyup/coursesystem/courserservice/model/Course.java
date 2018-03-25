package org.lyup.coursesystem.courserservice.model;

import java.util.HashSet;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@DynamoDBTable(tableName = "Course")
public @Data
class Course {

	// Partition key
    @DynamoDBHashKey(attributeName = "course_id")
    private String courseId;

    @DynamoDBAttribute(attributeName = "course_name")
    private String courseName;

    @DynamoDBAttribute(attributeName = "prof_id")
    private String profId;

    @DynamoDBAttribute(attributeName = "board")
    private String board;

    @DynamoDBAttribute(attributeName = "topic_arn")
    private String topicArn;
    
    @DynamoDBAttribute(attributeName = "lecture_set")
    private Set<String> lectureSet = new HashSet<>();

    @DynamoDBAttribute(attributeName = "announcement_set")
    private Set<String> announcementSet = new HashSet<>();
    
}
