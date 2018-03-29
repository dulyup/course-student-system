package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Professor;

public class AddProfTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Professor p = new Professor();
		p.setEmail("dulyup@gmail.com");
		p.setPFirstName("Lyup");
		p.setPLastName("Du");
		p.setCourseSet(new HashSet<String>());
		new ProfessorServiceImpl().addProfessor(p);
	}

}
