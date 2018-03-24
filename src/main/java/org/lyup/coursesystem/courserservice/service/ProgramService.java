package org.lyup.coursesystem.courserservice.service;

import java.util.List;
import org.lyup.coursesystem.courserservice.model.Program;

public interface ProgramService {

	/**
     * get all programs
     *
     * @return
     */
    public List<Program> listAllPrograms();

    /**
     * get program by id
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
}
