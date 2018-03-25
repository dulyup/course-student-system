package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Program;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

public class addProgram {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Program p = new Program();
//		p.setProgramTitle("Computer Science");
		p.setProgramTitle("Program Management");
		p.setCourseSet(new HashSet<String>());
		new ProgramServiceImpl().addProgram(p);
//		new ProgramServiceImpl().removeProgramById("prog0000");
		
	}

}
