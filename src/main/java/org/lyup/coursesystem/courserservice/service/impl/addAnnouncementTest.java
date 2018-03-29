package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Announcement;
import org.lyup.coursesystem.courseweb.manager.impl.CourseManagerImpl;

public class addAnnouncementTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Announcement a = new Announcement();
		a.setCourseId("c6805");
		a.setMessage("Hello!");
		new CourseManagerImpl().addAnnouncementByCourseIdAndAnnoun("c6805", a);
	}

}
