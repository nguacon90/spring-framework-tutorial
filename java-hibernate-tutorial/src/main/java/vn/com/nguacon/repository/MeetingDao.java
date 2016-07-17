package vn.com.nguacon.repository;

import java.util.List;

import vn.com.nguacon.model.Meeting;

public interface MeetingDao {
	void saveOrUpdate(Meeting meeting);

	Meeting findById(int id);

	List<Meeting> findAll();

	void delete(int id);
}
