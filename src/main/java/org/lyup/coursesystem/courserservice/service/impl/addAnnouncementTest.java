package org.lyup.coursesystem.courserservice.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Announcement;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

public class addAnnouncementTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Announcement a = new Announcement();
		a.setMessage("Can you receive the email?");
		a.setCourseId("c0001");
		new AnnouncementServiceImpl().addAnnouncement(a);
	}

}
