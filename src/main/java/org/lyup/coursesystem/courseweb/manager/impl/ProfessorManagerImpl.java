package org.lyup.coursesystem.courseweb.manager.impl;

import java.util.List;

import org.lyup.coursesystem.courserservice.model.Professor;
import org.lyup.coursesystem.courserservice.service.ProfessorService;
import org.lyup.coursesystem.courserservice.service.impl.ProfessorServiceImpl;
import org.lyup.coursesystem.courseweb.manager.ProfessorManager;

public class ProfessorManagerImpl implements ProfessorManager{

	private ProfessorService professorService = new ProfessorServiceImpl();
	
	@Override
	public List<Professor> listAllProfessors() {
		return professorService.listAllProfessors();
	}
	
	@Override
	public Professor getProfessorById(String id) {
		return professorService.getProfessorById(id);
	}

	@Override
	public Boolean addProfessor(Professor professor) {
		return professorService.addProfessor(professor);
	}

	@Override
	public Boolean updateProfessor(String id, Professor professor) {
		return professorService.updateProfessor(id, professor);
	}

	@Override
	public Boolean removeProfessorById(String id) {
		return professorService.removeProfessorById(id);
	}
	


}
