package vn.com.nguacon.service;

import java.util.List;

import vn.com.nguacon.model.Meeting;
import vn.com.nguacon.repository.MeetingDao;

public class MeetingServiceImpl implements MeetingService {
	
	private MeetingDao meetingDao;
	
	public MeetingServiceImpl(MeetingDao meetingDao) {
		this.meetingDao = meetingDao;
	}
	
	@Override
	public void saveOrUpdate(Meeting meeting) {
		meetingDao.saveOrUpdate(meeting);
	}

	@Override
	public Meeting findById(int id) {
		return meetingDao.findById(id);
	}

	@Override
	public List<Meeting> findAll() {
		return meetingDao.findAll();
	}

	@Override
	public void delete(int id) {
		meetingDao.delete(id);
	}

}
