package org.lyup.coursesystem.courserservice.service;

import java.util.List;

import org.lyup.coursesystem.courserservice.model.Course;

public interface CourseService {

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
}
