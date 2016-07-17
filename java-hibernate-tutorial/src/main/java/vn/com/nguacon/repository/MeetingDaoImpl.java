package vn.com.nguacon.repository;

import java.util.List;

import vn.com.nguacon.model.Meeting;

public class MeetingDaoImpl extends HibernateDaoSupport implements MeetingDao {

	@Override
	public void saveOrUpdate(Meeting meeting) {
		save(meeting);
	}

	@Override
	public Meeting findById(int id) {
		return (Meeting) get(Meeting.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meeting> findAll() {
		return findAll(Meeting.class);
	}

	@Override
	public void delete(int id) {
		Meeting meeting = findById(id);
		if(meeting == null) {
			throw new RuntimeException("Meeting is not existed.");
		}
		
		delete(meeting);
	}

}
