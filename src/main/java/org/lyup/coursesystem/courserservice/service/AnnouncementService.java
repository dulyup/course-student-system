package org.lyup.coursesystem.courserservice.service;

import org.lyup.coursesystem.courserservice.model.Announcement;

public interface AnnouncementService {

	/**
     * get announcement by id
     *
     * @param id
     * @return
     */
    public Announcement getAnnouncementById(String id);

    /**
     * add announcement
     * @param an
     * @return
     */
    public Boolean addAnnouncement(Announcement an);

    /**
     * update announcement
     * @param id
     * @param an
     * @return
     */
    public Boolean updateAnnouncement(String id, Announcement an);

    /**
     * remove announcement
     * @param id
     * @return
     */
    public Boolean removeAnnouncementById(String id);
    
}
