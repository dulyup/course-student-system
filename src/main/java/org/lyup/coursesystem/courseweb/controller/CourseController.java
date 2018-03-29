package org.lyup.coursesystem.courseweb.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.lyup.coursesystem.courserservice.model.Announcement;
import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.model.Professor;
import org.lyup.coursesystem.courserservice.model.Student;
import org.lyup.coursesystem.courseweb.manager.CourseManager;
import org.lyup.coursesystem.courseweb.manager.impl.CourseManagerImpl;

import java.util.List;

@Path("/courses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CourseController {

    private CourseManager courseManager = new CourseManagerImpl();

    @GET
    public List<Course> getAllCourses() {
        return courseManager.listAllCourses();
    }

    @GET
    @Path("/{courseId}")
    public Course getCourse(@PathParam("courseId") String id) {
        return courseManager.getCourseById(id);
    }

    @POST
    public Boolean addCourse(Course course) {
        return courseManager.addCourse(course);
    }

    @PUT
    @Path("/{courseId}")
    public Boolean updateCourse(@PathParam("courseId") String id, Course course) {
        return courseManager.updateCourse(id, course);
    }

    @DELETE
    @Path("/{courseId}")
    public Boolean removeCourse(@PathParam("courseId") String id) {
        return courseManager.removeCourseById(id);
    }

    @POST
    @Path("/{courseId}")
    public Boolean addAnnouncementByCourseId(@PathParam("courseId") String id, Announcement an) {
        return courseManager.addAnnouncementByCourseIdAndAnnoun(id, an);
    }

    @DELETE
    @Path("/{courseId}/{anId}")
    public Boolean removeAnnouncementByCourseId(@PathParam("courseId") String id, @PathParam("anId") String anId) {
        return courseManager.removeAnnouncementByCourseIdAndAnId(id, anId);
    }

    @POST
    @Path("/{courseId}/{professorId}")
    public Boolean addProfessorByCourseId(@PathParam("courseId") String id, @PathParam("professorId") String profId) {
        return courseManager.addCourseProfessorByCourseId(id, profId);
    }
    
    @GET
    @Path("/{courseId}/students")
    public List<Student> getCourseStudents(@PathParam("courseId") String id) {
        return courseManager.listAllStudents(id);
    }

    @Path("/{courseId}/lectures")
    public LectureController getLectureResource(@PathParam("courseId") String id) {
        return new LectureController();
    }

}
