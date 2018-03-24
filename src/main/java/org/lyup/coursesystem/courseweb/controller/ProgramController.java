package org.lyup.coursesystem.courseweb.controller;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.lyup.coursesystem.courserservice.model.Program;
import org.lyup.coursesystem.courseweb.manager.ProgramManager;
import org.lyup.coursesystem.courseweb.manager.impl.ProgramManagerImpl;

import java.util.List;

@Path("/programs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProgramController {

    private ProgramManager programManager = new ProgramManagerImpl();

    @GET
    public List<Program> listAllPrograms() {
        return programManager.listAllPrograms();
    }

    @GET
    @Path("/{programId}")
    public Program getProgramById(@PathParam("programId") String id) {
        return programManager.getProgramById(id);
    }

    @POST
    public boolean addProgram(Program program) {
        return programManager.addProgram(program);
    }

    @PUT
    @Path("/{programId}")
    public boolean updateProgram(@PathParam("programId") String id, Program program) {
        return programManager.updateProgram(id, program);
    }

    @DELETE
    @Path("/{programId}")
    public void removeProgram(@PathParam("programId") String id) {
        programManager.removeProgramById(id);
    }

//    @GET
//    @Path("/{programId}/courses")
//    public List<Course> listProgramCourses(@PathParam("programId") String id) {
//        return programManager.listProgramCoursesByProgramId(id);
//    }
//
//    @GET
//    @Path("/{programId}/students")
//    public List<Student> getProgramStudents(@PathParam("programId") String id) {
//        return programManager.listProgramStudentsByProgramId(id);
//    }
//
//    @POST
//    @Path("/{programId}/courses")
//    public boolean addProgramCourse(@PathParam("programId") String programId, String courseId) {
//        return programManager.addProgramCourseByProgramIdAndCourseId(programId, courseId);
//    }
//
//    @DELETE
//    @Path("/{programId}/courses")
//    public boolean removeProgramCourse(@PathParam("programId") String programId, String courseId) {
//        return programManager.removeProgramCourseByProgramIdAndCourseId(programId, courseId);
//    }
}
