package vn.com.nguacon.service;

import java.util.List;

import vn.com.nguacon.model.Meeting;

public interface MeetingService {

	void saveOrUpdate(Meeting meeting);

	Meeting findById(int id);

	List<Meeting> findAll();

	void delete(int id);

}
