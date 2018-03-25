package org.lyup.coursesystem.courserservice.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.lyup.coursesystem.courserservice.model.Lecture;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class addLecture {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Lecture l = new Lecture();
		l.setLectureId(IdGeneratorUtil.generateId("l", 4));
		l.setLectureTitle("is-xx");
		l.setMaterials(new ArrayList<String>());
		l.setNotes(new ArrayList<String>());
		l.setCourseId(IdGeneratorUtil.generateId("c", 2));
		
		Lecture l2 = new Lecture();
		l2.setLectureId(IdGeneratorUtil.generateId("l", 2));
		l2.setLectureTitle("cs-dd");
		l2.setMaterials(new ArrayList<String>());
		l2.setNotes(new ArrayList<String>());
		l2.setCourseId(IdGeneratorUtil.generateId("c", 1));
		
		Lecture l3 = new Lecture();
		l3.setLectureId(IdGeneratorUtil.generateId("l", 3));
		l3.setLectureTitle("is-ee");
		l3.setMaterials(new ArrayList<String>());
		l3.setNotes(new ArrayList<String>());
		l3.setCourseId(IdGeneratorUtil.generateId("c", 2));
		new LectureServiceImpl().addLecture(l);
		new LectureServiceImpl().addLecture(l2);
		new LectureServiceImpl().addLecture(l3);
	}

}
