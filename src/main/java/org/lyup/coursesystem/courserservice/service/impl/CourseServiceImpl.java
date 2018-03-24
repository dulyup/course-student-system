package org.lyup.coursesystem.courserservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.service.CourseService;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class CourseServiceImpl implements CourseService{

    private DynamoDBMapper mapper = ConnectDB.getMapper;

    @Override
    public List<Course> listAllCourses() {
        List<Course> courseList = new ArrayList<>();
        courseList.addAll(mapper.scan(Course.class, new DynamoDBScanExpression()));
        return courseList;
    }

    @Override
    public Course getCourseById(String id) {
        return mapper.load(Course.class, id);
    }

    @Override
    public Boolean addCourse(Course course) {
        mapper.save(course);
        return true;
    }

    @Override
    public Boolean updateCourse(String id, Course course) {
        course.setCourseId(id);
        mapper.save(course);
        return true;
    }

    @Override
    public Boolean removeCourseById(String id) {
        Course course = getCourseById(id);
        mapper.delete(course);
        return true;
    }

}