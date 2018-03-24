package org.lyup.coursesystem.courserservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.model.Student;
import org.lyup.coursesystem.courserservice.service.StudentService;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class StudentServiceImpl implements StudentService{

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