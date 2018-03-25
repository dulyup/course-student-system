package org.lyup.coursesystem.courserservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.model.Student;
import org.lyup.coursesystem.courserservice.service.StudentService;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;


public class StudentServiceImpl implements StudentService{

	private int count = (int) (Math.random()*10000);
    private DynamoDBMapper mapper = ConnectDB.getMapper;

    @Override
    public List<Student> listAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.addAll(mapper.scan(Student.class, new DynamoDBScanExpression()));
        return studentList;
    }

    @Override
    public Student getStudentById(String id) {
        return mapper.load(Student.class, id);
    }

    @Override
    public Boolean addStudent(Student student) {
    	//set id and maintain unique
    	String id = IdGeneratorUtil.generateId("s", count);
		while (getStudentById(id) != null) {
			id = IdGeneratorUtil.generateId("s", count);
		}
		student.setStuId(id);
		//deal with empty set problem which is not allowed by dynamodb 
		if (student.getCourseSet().size() == 0) {
			student.setCourseSet(null);
		}
        mapper.save(student);
        return true;
    }

    @Override
    public Boolean updateStudent(String id, Student student) {
        student.setStuId(id);
        mapper.save(student);
        return true;
    }

    @Override
    public Boolean removeStudentById(String id) {
        Student student = getStudentById(id);
        mapper.delete(student);
        return true;
    }
    
}