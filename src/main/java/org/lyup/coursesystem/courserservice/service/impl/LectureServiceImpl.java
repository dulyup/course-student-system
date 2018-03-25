package org.lyup.coursesystem.courserservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.model.Lecture;
import org.lyup.coursesystem.courserservice.service.LectureService;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class LectureServiceImpl implements LectureService{

	private int count = (int) (Math.random()*10000);
    private DynamoDBMapper mapper = ConnectDB.getMapper;

    @Override
    public List<Lecture> listAllLectures() {
        List<Lecture> lectureList = new ArrayList<>();
        lectureList.addAll(mapper.scan(Lecture.class, new DynamoDBScanExpression()));
        return lectureList;
    }

    @Override
    public Lecture getLectureById(String id) {
        return mapper.load(Lecture.class, id);
    }

    @Override
    public Boolean addLecture(Lecture lecture) {
    		//set id and maintain unique
		String id = IdGeneratorUtil.generateId("l", count);
		while (getLectureById(id) != null) {
			id = IdGeneratorUtil.generateId("l", count);
		}
    		lecture.setLectureId(id);
        mapper.save(lecture);
        return true;
    }

    @Override
    public Boolean updateLecture(String id, Lecture lecture) {
        lecture.setLectureId(id);
        mapper.save(lecture);
        return true;
    }

    @Override
    public Boolean removeLectureById(String id) {
        Lecture lecture = getLectureById(id);
        mapper.delete(lecture);
        return true;
    }
}