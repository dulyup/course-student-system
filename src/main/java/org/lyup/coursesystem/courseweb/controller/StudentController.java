package org.lyup.coursesystem.courseweb.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.model.Student;
import org.lyup.coursesystem.courseweb.manager.StudentManager;
import org.lyup.coursesystem.courseweb.manager.impl.StudentManagerImpl;

import java.util.List;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON) //POST method parameter student is consumed JSON
@Produces(MediaType.APPLICATION_JSON) //Produce the parameter JSON
public class StudentController {

    private StudentManager studentManager = new StudentManagerImpl();

    @GET
    public List<Student> getAllStudents() {
        return studentManager.listAllStudents();
    }

    @GET
    @Path("/{studentId}")
    public Student getStudent(@PathParam("studentId") String id) {
        return studentManager.getStudentById(id);
    }

    @POST
    public Boolean addStudent(Student student) {
        return studentManager.addStudent(student);
    }

    @PUT
    @Path("/{studentId}")
    public Boolean updateStudent(@PathParam("studentId") String id, Student student) {
        return studentManager.updateStudent(id, student);
    }

    @DELETE
    @Path("/{studentId}")
    public Boolean deleteStudent(@PathParam("studentId") String id) {
        return studentManager.removeStudentById(id);
    }

    @GET
    @Path("/{studentId}/courses")
    public List<Course> getCourseResource(@PathParam("studentId") String id) {
        return studentManager.listCourseList(id);
    }

    @POST
    @Path("/{studentId}/{courseId}")
    public Boolean addStudentCourseByAndStuIdCourseId(@PathParam("studentId") String stuId, @PathParam("courseId") String courseId) {
        return studentManager.addStudentCourseByStudentIdAndCourseId(stuId, courseId);
    }

    @DELETE
    @Path("/{studentId}/{courseId}")
    public Boolean removeStudentCourseByStudentIdAndCourseId(@PathParam("studentId") String stuId, @PathParam("courseId") String courseId) {
        return studentManager.removeStudentCourseByStudentIdAndCourseId(stuId, courseId);
    }
}
