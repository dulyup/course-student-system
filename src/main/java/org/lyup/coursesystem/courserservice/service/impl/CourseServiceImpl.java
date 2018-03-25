package org.lyup.coursesystem.courserservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.lambda.EmailStudentAnnouncement;
import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.service.CourseService;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class CourseServiceImpl implements CourseService{

	private int count = (int) (Math.random()*10000);
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
    		//set id and maintain unique
	    	String id = IdGeneratorUtil.generateId("c", count);
		while (getCourseById(id) != null) {
			id = IdGeneratorUtil.generateId("c", count);
		}
		course.setCourseId(id);
		//deal with empty set problem which is not allowed by dynamodb 
		if (course.getLectureSet().size() == 0) {
			course.setLectureSet(null);
		}
    		course.setTopicArn(EmailStudentAnnouncement.createTopic("course"));
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