package org.lyup.coursesystem.courserservice.service.impl;


import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.model.Professor;
import org.lyup.coursesystem.courserservice.service.ProfessorService;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class ProfessorServiceImpl implements ProfessorService{

	private int count = (int) (Math.random()*10000);
	private DynamoDBMapper mapper = ConnectDB.getMapper;

	@Override
	public Professor getProfessorById(String id) {
		return mapper.load(Professor.class, id);
	}

	@Override
	public Boolean addProfessor(Professor professor) {
		//set id and maintain unique
		String id = IdGeneratorUtil.generateId("prog", count);
		while (getProfessorById(id) != null) {
			id = IdGeneratorUtil.generateId("prog", count);
		}
		//deal with empty set problem which is not allowed by dynamodb 
		if (professor.getCourseSet().size() == 0) {
			professor.setCourseSet(null);
		}
		professor.setProfId(id);
		mapper.save(professor);
		return true;
	}
	

	
}
