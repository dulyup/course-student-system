package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Course;

public class addCourseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Course c = new Course();
		c.setProfId("prof6002");
		c.setBoard("");
		c.setAnnouncementSet(new HashSet<String>());
		c.setCourseName("Java");
		c.setLectureSet(new HashSet<String>());
		new CourseServiceImpl().addCourse(c);
	}

}
