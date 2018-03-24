package org.lyup.coursesystem.courseweb.manager;

import java.util.List;

import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.model.Student;

public interface StudentManager {

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

    /**
     * get course list of a student
     *
     * @param id
     * @return
     */
    public List<Course> listCourseList(String id);

    /**
     * add course for a student
     *
     * @param stuId
     * @param courseId
     * @return
     */
    public Boolean addStudentCourseByStudentIdAndCourseId(String stuId, String courseId);

    /**
     * remove course for a student
     *
     * @param stuId
     * @param courseId
     * @return
     */
    public Boolean removeStudentCourseByStudentIdAndCourseId(String stuId, String courseId);

}
