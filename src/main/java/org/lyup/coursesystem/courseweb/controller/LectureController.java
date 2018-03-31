package org.lyup.coursesystem.courseweb.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.lyup.coursesystem.courserservice.model.Lecture;
import org.lyup.coursesystem.courseweb.manager.LectureManager;
import org.lyup.coursesystem.courseweb.manager.impl.LectureManagerImpl;

import java.util.List;

@Path("/lectures")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LectureController {

    private LectureManager lectureManger = new LectureManagerImpl();

    @GET
    public List<Lecture> getCourseLectures(@PathParam("courseId") String id) {
        return lectureManger.listCourseLectures(id);
    }

    @GET
    @Path("/{lectureId}")
    public Lecture getLecture(@PathParam("lectureId") String id) {
        return lectureManger.getLectureById(id);
    }

    @POST
    public Boolean addLecture(Lecture lecture) {
        return lectureManger.addLecture(lecture);
    }

    @PUT
    @Path("/{lectureId}")
    public Boolean updateLecture(@PathParam("lectureId") String id, Lecture lecture) {
        return lectureManger.updateLecture(id, lecture);
    }

    @DELETE
    @Path("/{lectureId}")
    public Boolean removeLecture(@PathParam("lectureId") String id) {
        return lectureManger.removeLectureById(id);
    }


}
