package org.lyup.coursesystem.courseweb.manager;

import java.util.List;

import org.lyup.coursesystem.courserservice.model.Announcement;
import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.model.Lecture;
import org.lyup.coursesystem.courserservice.model.Student;

public interface CourseManager {

	/**
     * get all courses
     *
     * @return
     */
    public List<Course> listAllCourses();

    /**
     * get course by id
     *
     * @param id course id
     * @return A specific course
     */
    public Course getCourseById(String id);

    /**
     * Add course
     *
     * @param course
     * @return
     */
    public Boolean addCourse(Course course);

    /**
     * update course
     *
     * @param id
     * @param course
     * @return
     */
    public Boolean updateCourse(String id, Course course);

    /**
     * delete course
     *
     * @param id
     * @return
     */
    public Boolean removeCourseById(String id);


    /**
     * get all lectures of a course
     *
     * @param id
     * @return
     */
    public List<Lecture> listAllLectures(String id);

    /**
     * get all students of a course
     *
     * @param id
     * @return
     */
    public List<Student> listAllStudents(String id);

    /**
     * add a student to a course
     *
     * @param courseId
     * @param stuId
     * @return
     */
    public Boolean addCourseStudentByCourseIdAndStuId(String courseId, String stuId);

    /**
     * remove a student from a course
     *
     * @param courseId
     * @param stuId
     * @return
     */
    public Boolean removeCourseStudentByCourseIdAndStuId(String courseId, String stuId);

    /**
     * add an announcement for a course
     * @param courseId
     * @param an
     * @return
     */
    public Boolean addAnnouncementByCourseIdAndAnnoun(String courseId, Announcement an);

    /**
     * remove an announcement from a course
     * @param courseId
     * @param anId
     * @return
     */
    public Boolean removeAnnouncementByCourseIdAndAnId(String courseId, String anId);
}
