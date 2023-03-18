package com.hibernate1.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate1.entity.Address;
import com.hibernate1.entity.Student;

public class DBSession {
	
	private final SessionFactory factory ;
	private Session session;
	
	static DBSession dbSession ;
	
	private DBSession() throws HibernateException {
		super();
		
		factory = new Configuration().configure("hibernate.config.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Address.class).buildSessionFactory();
		session = factory.getCurrentSession();
	}
	
	public static DBSession getDBSession() {
		if(dbSession == null)
			dbSession = new DBSession();
		
		return dbSession;
			
	}

	public void run() throws HibernateException {
		
		Address address = new Address("India" , "A.P", "Vijayawada", "Z.P.H.S", "1-78");
		
		Student student = new Student("Minoosh" , "y17cs065", address);
		
		System.out.println("**Saving student and address");
		
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		
		Integer id = (Integer)session.save(student);
		
		transaction.commit();
		
		session.close();
		
		session = factory.getCurrentSession();
		
		transaction = session.getTransaction();
		
		transaction.begin();
		
		
		Student student1 = session.get(Student.class, id);
		
		System.out.println("**saved student "+student1);
		
		System.out.println("** deleting student with id "+student1.getId()+" also deletes address");
		
		
		session.delete(student1);
		transaction.commit();
	
	}
	
}
