package org.lyup.coursesystem.courserservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.model.Program;
import org.lyup.coursesystem.courserservice.service.ProgramService;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class ProgramServiceImpl implements ProgramService{

	private int count = (int) (Math.random()*10000);
	private DynamoDBMapper mapper = ConnectDB.getMapper;

    @Override
    public List<Program> listAllPrograms() {
        List<Program> programList = new ArrayList<>();
        programList.addAll(mapper.scan(Program.class, new DynamoDBScanExpression()));
        return programList;
    }

    @Override
    public Program getProgramById(String id) {
        return mapper.load(Program.class, id);
    }

    @Override
    public Boolean addProgram(Program program) {
    		//set id and maintain unique
    		String id = IdGeneratorUtil.generateId("prog", count);
		while (getProgramById(id) != null) {
			id = IdGeneratorUtil.generateId("prog", count);
		}
		program.setProgramId(id);
		//deal with empty set problem which is not allowed by dynamodb 
		if (program.getCourseSet().size() == 0) {
			program.setCourseSet(null);
		}
        mapper.save(program);
        return true;
    }

    @Override
    public Boolean updateProgram(String id, Program program) {
        program.setProgramId(id);;
        mapper.save(program);
        return true;
    }

    @Override
    public Boolean removeProgramById( String id) {
        Program program = getProgramById(id);
        mapper.delete(program);
        return true;
    }

}
