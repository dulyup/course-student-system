package org.lyup.coursesystem.courserservice.service.impl;


import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Student;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

public class AddStudent {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Student s = new Student();
		s.setStuId(IdGeneratorUtil.generateId("s", 2));
		s.setFirstName("Pitter");
		s.setLastName("Brownn");
		s.setEmail("pitter@gmail.com");
		s.setProgramId("prog0001");
		s.setCourseSet(new HashSet<>(Arrays.asList("c0001")));
		new StudentServiceImpl().addStudent(s);
	}

}
