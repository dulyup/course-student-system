package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Program;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

public class AddProgramTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Program program = new Program();
		program.setProgramId(IdGeneratorUtil.generateId("program", 1));
		program.setProgramTitle("Computer Science");
		program.setCourseSet(new HashSet<>(Arrays.asList("course0000001")));
		new ProgramServiceImpl().addProgram(program);
	}

}
