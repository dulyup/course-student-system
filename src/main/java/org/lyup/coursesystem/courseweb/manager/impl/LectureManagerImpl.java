package org.lyup.coursesystem.courseweb.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.model.Lecture;
import org.lyup.coursesystem.courserservice.service.CourseService;
import org.lyup.coursesystem.courserservice.service.LectureService;
import org.lyup.coursesystem.courserservice.service.impl.CourseServiceImpl;
import org.lyup.coursesystem.courserservice.service.impl.LectureServiceImpl;
import org.lyup.coursesystem.courseweb.manager.LectureManager;

public class LectureManagerImpl implements LectureManager{

    private LectureService lectureService = new LectureServiceImpl();
    private CourseService courseService = new CourseServiceImpl();

    @Override
    public List<Lecture> listCourseLectures(String courseId) {
        List<Lecture> courseLectureList = new ArrayList<>();
        List<Lecture> lectureList = lectureService.listAllLectures();
        for (String lectureId: courseService.getCourseById(courseId).getLectureSet()) {
            for (Lecture lecture: lectureList) {
                if (lectureId.equals(lecture.getLectureId())) {
                    courseLectureList.add(lecture);
                    break;
                }
            }
        }
        return courseLectureList;
    }

    @Override
    public Lecture getLectureById(String id) {
        return lectureService.getLectureById(id);
    }

    @Override
    public Boolean addLecture(Lecture lecture) {
        courseService.getCourseById(lecture.getCourseId()).getLectureSet().add(lecture.getLectureId());
        return lectureService.addLecture(lecture);
    }

    @Override
    public Boolean updateLecture(String id, Lecture lecture) {
        return lectureService.updateLecture(id, lecture);
    }

    @Override
    public Boolean removeLectureById(String id) {
        Lecture lecture = lectureService.getLectureById(id);
        courseService.getCourseById(lecture.getCourseId()).getLectureSet().remove(id);
        return lectureService.removeLectureById(id);
    }
}