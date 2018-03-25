package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.lambda.EmailStudentNotif;
import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

public class addCourse {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Course c = new Course();
		Set<String> set = new HashSet<>(Arrays.asList("1","2"));
//		c.setCourseId(IdGeneratorUtil.generateId("c", 1));
//		c.setCourseName("Java");
//		c.setLectureSet(set);
//		c.setProfId(IdGeneratorUtil.generateId("p", 1));
//		c.setBoard("");
//		c.setTopicArn(EmailStudentNotif.createTopic(c.getCourseName()));
//		c.setAnnouncementSet(set);
		c.setCourseId(IdGeneratorUtil.generateId("c", 2));
		c.setCourseName("Java");
		c.setLectureSet(set);
		c.setProfId(IdGeneratorUtil.generateId("p", 1));
		c.setBoard("");
		c.setTopicArn(EmailStudentNotif.createTopic(c.getCourseName()));
		c.setAnnouncementSet(set);
		new CourseServiceImpl().addCourse(c);
	}

}
