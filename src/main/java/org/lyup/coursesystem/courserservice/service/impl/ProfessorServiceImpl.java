package org.lyup.coursesystem.courserservice.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.model.Professor;
import org.lyup.coursesystem.courserservice.service.ProfessorService;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

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
		String id = IdGeneratorUtil.generateId("prof", count);
		while (getProfessorById(id) != null) {
			id = IdGeneratorUtil.generateId("prof", count);
		}
		//deal with empty set problem which is not allowed by dynamodb 
		if (professor.getCourseSet().size() == 0) {
			professor.setCourseSet(null);
		}
		professor.setProfId(id);
		mapper.save(professor);
		return true;
	}

	@Override
	public List<Professor> listAllProfessors() {
		List<Professor> professorList = new ArrayList<>();
		professorList.addAll(mapper.scan(Professor.class, new DynamoDBScanExpression()));
        return professorList;
	}

	@Override
	public Boolean updateProfessor(String id, Professor professor) {
		professor.setProfId(id);
		if (professor.getCourseSet().size() == 0) {
			professor.setCourseSet(null);
		}
        mapper.save(professor);
        return true;
	}

	@Override
	public Boolean removeProfessorById(String id) {
		Professor professor = getProfessorById(id);
	    mapper.delete(professor);
	    return true;
	}
	
}
