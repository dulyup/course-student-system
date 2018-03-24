package org.lyup.coursesystem.courserservice.service;

import java.util.List;

import org.lyup.coursesystem.courserservice.model.Lecture;

public interface LectureService {

	/**
     * get all lectures
     *
     * @return
     */
    public List<Lecture> listAllLectures();

    /**
     * get lecture by id
     *
     * @param id lecture id
     * @return A specific lecture
     */
    public Lecture getLectureById(String id);

    /**
     * Add lecture
     *
     * @param lecture
     * @return
     */
    public Boolean addLecture(Lecture lecture);

    /**
     * update lecture
     * @param id
     * @param lecture
     * @return
     */
    public Boolean updateLecture(String id, Lecture lecture);

    /**
     * delete lecture
     *
     * @param id
     * @return
     */
    public Boolean removeLectureById(String id);

}
