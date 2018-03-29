package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Student;
import org.lyup.coursesystem.courseweb.manager.impl.StudentManagerImpl;

public class addStudentCourseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		new StudentManagerImpl().addStudentCourseByStudentIdAndCourseId("s1687", "c6805");
	}

}
