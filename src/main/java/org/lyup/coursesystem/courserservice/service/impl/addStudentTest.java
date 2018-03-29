package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Student;

public class addStudentTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Student s = new Student();
		s.setProgramId("prog9500");
		s.setEmail("dulyup@gmail.com");
		s.setFirstName("Lyup");
		s.setLastName("Du");
		s.setImage("");
		s.setCourseSet(new HashSet<String>());
		new StudentServiceImpl().updateStudent("s1687",s);
	}

}
