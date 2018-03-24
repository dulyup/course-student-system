package org.lyup.coursesystem.courseweb.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.model.Student;
import org.lyup.coursesystem.courserservice.service.CourseService;
import org.lyup.coursesystem.courserservice.service.StudentService;
import org.lyup.coursesystem.courserservice.service.impl.CourseServiceImpl;
import org.lyup.coursesystem.courserservice.service.impl.StudentServiceImpl;
import org.lyup.coursesystem.courseweb.manager.StudentManager;

public class StudentManagerImpl implements StudentManager{

	private StudentService studentService = new StudentServiceImpl();
    private CourseService courseService = new CourseServiceImpl();

    @Override
    public List<Student> listAllStudents() {
        return studentService.listAllStudents();
    }

    @Override
    public Student getStudentById(String id) {
        return studentService.getStudentById(id);
    }

    @Override
    public Boolean addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @Override
    public Boolean updateStudent(String id, Student student) {
        return studentService.updateStudent(id, student);
    }

    @Override
    public Boolean removeStudentById(String id) {
        return studentService.removeStudentById(id);
    }

    @Override
    public List<Course> listCourseList(String id) {
        List<Course> studentCourseList = new ArrayList<>();
        List<Course> courseList = courseService.listAllCourses();
        for (String enrolledCourseId : studentService.getStudentById(id).getCourseSet()) {
            for (Course course : courseList) {
                if (enrolledCourseId.equals(course.getCourseId())) {
                    studentCourseList.add(course);
                    break;
                }
            }
        }
        return studentCourseList;
    }

    @Override
    public Boolean addStudentCourseByStudentIdAndCourseId(String stuId, String courseId) {
        return studentService.getStudentById(stuId).getCourseSet().add(courseId);
    }

    @Override
    public Boolean removeStudentCourseByStudentIdAndCourseId(String stuId, String courseId) {
        return studentService.getStudentById(stuId).getCourseSet().remove(courseId);
    }
}
