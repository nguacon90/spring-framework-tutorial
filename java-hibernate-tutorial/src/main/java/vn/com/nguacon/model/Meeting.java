package vn.com.nguacon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="meetings")
public class Meeting {
	
	@Id
	@Column(name="meetingId", unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer meetingId;
	
	@Column(name="subject", nullable=false)
	private String subject;
	
	@Column(name="meetingDate", nullable=false)
	private Date meetingDate;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinTable(name = "employees_meetings", 	
	joinColumns = { @JoinColumn(name = "meetingId") }, inverseJoinColumns = {
	@JoinColumn(name = "employeeId") })
	private List<Employee> employees;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", subject=" + subject + ", meetingDate=" + meetingDate + ", employees="
				+ employees + "]";
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}
	
}
