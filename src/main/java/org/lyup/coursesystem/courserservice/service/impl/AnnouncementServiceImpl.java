package org.lyup.coursesystem.courserservice.service.impl;

import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.model.Announcement;
import org.lyup.coursesystem.courserservice.service.AnnouncementService;
import org.lyup.coursesystem.courserservice.util.IdGeneratorUtil;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class AnnouncementServiceImpl implements AnnouncementService{

	private int count = (int) (Math.random()*10000);
    private DynamoDBMapper mapper = ConnectDB.getMapper;

    @Override
    public Announcement getAnnouncementById(String id) {
        return mapper.load(Announcement.class, id);
    }

    @Override
    public Boolean addAnnouncement(Announcement an) {
    		String id = IdGeneratorUtil.generateId("a", count);
		while (getAnnouncementById(id) != null) {
			id = IdGeneratorUtil.generateId("a", count);
		}
		an.setAnId(id);
        mapper.save(an);
        return true;
    }

    @Override
    public Boolean updateAnnouncement(String id, Announcement an) {
        an.setCourseId(id);
        mapper.save(an);
        return true;
    }

    @Override
    public Boolean removeAnnouncementById(String id) {
        Announcement announcement = getAnnouncementById(id);
        mapper.delete(announcement);
        return true;
    }
}