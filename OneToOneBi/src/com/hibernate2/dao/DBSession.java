package com.hibernate2.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate2.entity.Address;
import com.hibernate2.entity.Student;

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
		
		session = factory.getCurrentSession();
		
		Address address = new Address("India" , "A.P", "Vijayawada", "Z.P.H.S", "1-78");
		
		Student student = new Student("Minoosh" , "y17cs065", address);
		
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		session.save(student);
		transaction.commit();
		session.close();
		
		System.out.println("*** getting student details by address");
		session = factory.getCurrentSession();
		transaction = session.getTransaction();
		transaction.begin();
		Address address2 = session.get(Address.class, address.getAddressId());
		Student student2 = address2.getStudent() ;
		
		System.out.println(student2);
		transaction.commit();
		
		
		
		
		System.out.println("**Deleting addresid "+address.getAddressId()+" will also delete asssocated student");
		session = factory.getCurrentSession();
		transaction = session.getTransaction();
		transaction.begin();
		Address address1 = session.get(Address.class, address.getAddressId());
		session.delete(address1);
		transaction.commit();
	
	}
	
}
