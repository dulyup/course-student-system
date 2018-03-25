package org.lyup.coursesystem.courseweb.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.model.Announcement;
import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.model.Lecture;
import org.lyup.coursesystem.courserservice.model.Student;
import org.lyup.coursesystem.courserservice.service.AnnouncementService;
import org.lyup.coursesystem.courserservice.service.CourseService;
import org.lyup.coursesystem.courserservice.service.LectureService;
import org.lyup.coursesystem.courserservice.service.StudentService;
import org.lyup.coursesystem.courserservice.service.impl.AnnouncementServiceImpl;
import org.lyup.coursesystem.courserservice.service.impl.CourseServiceImpl;
import org.lyup.coursesystem.courserservice.service.impl.LectureServiceImpl;
import org.lyup.coursesystem.courserservice.service.impl.StudentServiceImpl;
import org.lyup.coursesystem.courseweb.manager.CourseManager;

public class CourseManagerImpl implements CourseManager{

	private CourseService courseService = new CourseServiceImpl();
    private LectureService lectureService = new LectureServiceImpl();
    private StudentService studentService = new StudentServiceImpl();
    private AnnouncementService announcementService = new AnnouncementServiceImpl();

    @Override
    public List<Course> listAllCourses() {
        return courseService.listAllCourses();
    }

    @Override
    public Course getCourseById(String id) {
        return courseService.getCourseById(id);
    }

    @Override
    public Boolean addCourse(Course course) {
        return courseService.addCourse(course);
    }

    @Override
    public Boolean updateCourse(String id, Course course) {
        return courseService.updateCourse(id, course);
    }

    @Override
    public Boolean removeCourseById(String id) {
        return courseService.removeCourseById(id);
    }

    @Override
    public List<Lecture> listAllLectures(String id) {
        List<Lecture> courseLectureList = new ArrayList<>();
        List<Lecture> lectureList = lectureService.listAllLectures();
        for (Lecture lecture: lectureList) {
            if (id.equals(lecture.getCourseId())) {
                courseLectureList.add(lecture);
            }
        }
        return courseLectureList;
    }

    @Override
    public List<Student> listAllStudents(String id) {
        List<Student> courseStudentList = new ArrayList<>();
        List<Student> studentList = studentService.listAllStudents();
        for (Student student: studentList) {
            for (String enrolledCourseId: student.getCourseSet()) {
                if (id.equals(enrolledCourseId)) {
                    courseStudentList.add(student);
                }
            }
        }
        return courseStudentList;
    }

    @Override
    public Boolean addCourseStudentByCourseIdAndStuId(String courseId, String stuId) {
        studentService.getStudentById(stuId).getCourseSet().add(courseId);
        return true;
    }

    @Override
    public Boolean removeCourseStudentByCourseIdAndStuId(String courseId, String stuId) {
        studentService.getStudentById(stuId).getCourseSet().remove(courseId);
        return true;
    }

    @Override
    public Boolean addAnnouncementByCourseIdAndAnnoun(String courseId, Announcement an) {
        announcementService.addAnnouncement(an);
        courseService.getCourseById(courseId).getAnnouncementSet().add(an.getAnId());
        return true;
    }

    @Override
    public Boolean removeAnnouncementByCourseIdAndAnId(String courseId, String anId) {
        courseService.getCourseById(courseId).getAnnouncementSet().remove(anId);
        announcementService.removeAnnouncementById(anId);
        return true;
    }

}
