package org.lyup.coursesystem.courseweb.manager;

import java.util.List;

import org.lyup.coursesystem.courserservice.model.*;
public interface ProgramManager {

	/**
     * get all programs
     *
     * @return
     */
    public List<Program> listAllPrograms();

    /**
     * get course by id
     *
     * @param id course id
     * @return A specific program
     */
    public Program getProgramById(String id);

    /**
     * Add program
     *
     * @param program
     * @return
     */
    public Boolean addProgram(Program program);

    /**
     * update program
     *
     * @param id      program id
     * @param program
     * @return
     */
    public Boolean updateProgram(String id, Program program);

    /**
     * delete program
     *
     * @param id
     * @return
     */
    public Boolean removeProgramById(String id);

    /**
     * get all courses of a program
     *
     * @param id
     * @return
     */
    public List<Course> listProgramCoursesByProgramId(String id);

    /**
     * get all students of a program
     *
     * @param id
     * @return
     */
    public List<Student> listProgramStudentsByProgramId(String id);

    /**
     * add course for a program
     *
     * @param programId
     * @param courseId
     * @return
     */
    public Boolean addProgramCourseByProgramIdAndCourseId(String programId, String courseId);

    /**
     * delete course from a program
     *
     * @param programId
     * @param courseId
     * @return
     */
    public Boolean removeProgramCourseByProgramIdAndCourseId(String programId, String courseId);
    
}
