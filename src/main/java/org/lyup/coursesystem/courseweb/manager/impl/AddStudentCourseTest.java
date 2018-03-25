package org.lyup.coursesystem.courseweb.manager.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddStudentCourseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		new StudentManagerImpl().addStudentCourseByStudentIdAndCourseId("s0001", "c0001");
	}

}
