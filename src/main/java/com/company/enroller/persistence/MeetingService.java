package com.company.enroller.persistence;

import com.company.enroller.model.Meeting;
import com.company.enroller.model.Participant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("meetingService")
public class MeetingService {

	Session session;

	public MeetingService() {
		session = DatabaseConnector.getInstance().getSession();
	}

	public Collection<Meeting> getAll() {
		String hql = "FROM Meeting";
		Query query = this.session.createQuery(hql);
		return query.list();
	}

	public Meeting findById(long id) {
		return session.getSession().get(Meeting.class, id);
	}
	public Meeting getID(int id) {
		return session.getSession().get(Meeting.class, id);
	}
	public void add(Meeting meeting) {
		Transaction transaction = session.getSession().beginTransaction();
		session.getSession().save(meeting);
		transaction.commit();
	}
	public void update(Meeting meeting) {
		Transaction transaction = session.getSession().beginTransaction();
		session.getSession().merge(meeting);
		transaction.commit();
	}

	public void delete(Meeting meeting) {
		Transaction transaction = session.getSession().beginTransaction();
		session.getSession().delete(meeting);
		transaction.commit();
	}


}
