package org.lyup.coursesystem.courserservice.service;

import java.util.List;

import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.model.Professor;

public interface ProfessorService {
	
	/**
     * get all professor
     *
     * @return
     */
    public List<Professor> listAllProfessors();

    /**
     * get professor by id
     *
     * @param id professor id
     * @return A specific professor
     */
    public Professor getProfessorById(String id);

    /**
     * Add professor
     *
     * @param professor
     * @return
     */
    public Boolean addProfessor(Professor professor);

    /**
     * update professor
     *
     * @param id
     * @param professor
     * @return
     */
    public Boolean updateProfessor(String id, Professor professor);

    /**
     * delete professor
     *
     * @param id
     * @return
     */
    public Boolean removeProfessorById(String id);
}
