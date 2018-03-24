package org.lyup.coursesystem.courserservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "Lecture")
public @Data
class Lecture {

    // Partition key
    @DynamoDBHashKey(attributeName = "lecture_id")
    private String lectureId;

    @DynamoDBAttribute(attributeName = "course_id")
    private String courseId;

    @DynamoDBAttribute(attributeName = "lecture_title")
    private String lectureTitle;

    @DynamoDBAttribute(attributeName = "notes")
    private List<String> notes = new ArrayList<>();

    @DynamoDBAttribute(attributeName = "materials")
    private List<String> materials = new ArrayList<>();


}