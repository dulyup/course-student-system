package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Program;

public class addProgramTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Program p = new Program();
		p.setCourseSet(new HashSet<String>(Arrays.asList("c6805")));
		p.setProgramTitle("Information Systems");
		new ProgramServiceImpl().addProgram(p);
	}

}
