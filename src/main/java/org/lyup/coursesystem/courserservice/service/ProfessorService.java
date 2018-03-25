package org.lyup.coursesystem.courserservice.service;

import org.lyup.coursesystem.courserservice.model.Professor;

public interface ProfessorService {

	
	public Boolean addProfessor(Professor professor);
	
	public Professor getProfessorById(String id);
}
