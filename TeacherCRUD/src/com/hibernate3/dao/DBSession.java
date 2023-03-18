package com.hibernate3.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate3.entity.Teacher;

public class DBSession {

	private SessionFactory sessionFactory ;
	
	private static DBSession dbSession ;
	

	private DBSession() {
		sessionFactory = new Configuration().configure("hibernate.config.xml").addAnnotatedClass(Teacher.class).buildSessionFactory();
	}
	
	public static DBSession getDBConnection() {
		if(dbSession == null)
			dbSession = new DBSession();
		return dbSession ;
	}
	
	
	public Teacher addTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession() ;
		
		session.getTransaction().begin();;
		
		
		 session.save(teacher);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("**teacher with name "+teacher.firstName+","+teacher.lastName+"is successfully saved");
		return teacher ;
	}
	
	public void updateTeacher(Teacher teacher) {
		
		Teacher teacher1;
		Session session = sessionFactory.getCurrentSession() ;
		
		session.getTransaction().begin();
		
		teacher1 = session.get(Teacher.class , teacher.id);
		session.saveOrUpdate(teacher1);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("**teacher with name "+teacher.firstName+","+teacher.lastName+"is successfully updated from ");
		System.out.println(teacher1+" To");
		System.out.println(teacher) ;
	}
	
	public Teacher getTeacher(int id) {
		Teacher teacher ;
		
		Session session = sessionFactory.getCurrentSession() ;
		
		session.getTransaction().begin();
		
		
		teacher = session.get(Teacher.class , id);
		
		session.getTransaction().commit();
		session.close();
		
		return teacher ;
	}
	
	public void deleteTeacher(int id) {
		Teacher teacher ;
		
		Session session = sessionFactory.getCurrentSession() ;
		
		session.getTransaction().begin();
		
		teacher = session.get(Teacher.class , id);
		session.delete(teacher);
		
		session.getTransaction().commit();
		session.close();
		
		
		
	}
	
}
