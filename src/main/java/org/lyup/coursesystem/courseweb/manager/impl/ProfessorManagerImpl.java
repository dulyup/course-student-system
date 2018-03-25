package org.lyup.coursesystem.courseweb.manager.impl;

import org.lyup.coursesystem.courserservice.model.Professor;
import org.lyup.coursesystem.courserservice.service.ProfessorService;
import org.lyup.coursesystem.courserservice.service.impl.ProfessorServiceImpl;
import org.lyup.coursesystem.courseweb.manager.ProfessorManager;

public class ProfessorManagerImpl implements ProfessorManager{

	private ProfessorService professorService = new ProfessorServiceImpl();
	
	@Override
	public Professor getProfessorById(String id) {
		return professorService.getProfessorById(id);
	}

}
