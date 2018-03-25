package org.lyup.coursesystem.courserservice.service;

import java.util.List;

import org.lyup.coursesystem.courserservice.model.Student;

public interface StudentService {

	/**
     * get all students
     *
     * @return
     */
    public List<Student> listAllStudents();

    /**
     * get student by id
     *
     * @param id student id
     * @return A specific student
     */
    public Student getStudentById(String id);

    /**
     * Add student
     *
     * @param student
     * @return
     */
    public Boolean addStudent(Student student);

    /**
     * update student
     *
     * @param student
     * @return
     */
    public Boolean updateStudent(String id, Student student);

    /**
     * delete student
     *
     * @param id
     * @return
     */
    public Boolean removeStudentById(String id);

    
}
