package com.hibernate5.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Course;
import com.hibernate5.entity.Student;


public class DBSession {

	private SessionFactory sessionFactory ;
	
	private static DBSession dbSession ;
	

	private DBSession() {
		sessionFactory = new Configuration().configure("hibernate.config.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
	}
	
	public static DBSession getDBConnection() {
		if(dbSession == null)
			dbSession = new DBSession();
		return dbSession ;
	}
	
	
	public void run() {
		
		
		Student student = new Student("Minoosh" , new ArrayList<>());
		
		Course course1 = new Course("DSA", student);
		
		Course course2 = new Course("Java", student);
		List<Course> list = new ArrayList<>();
		list.add(course1);
		list.add(course2);
		
		student.setCourses(list);
		
		
		Session session = sessionFactory.getCurrentSession() ;
		
		session.beginTransaction() ;
		
		Integer id = (Integer) session.save(student);
		
		
		session.save(course1);
		session.save(course2);
		
		System.out.println("**"+student);
		
		
		session.delete(course1);
		
		session.getTransaction().commit();
		
		session.close();
		
		
		
		
		
		session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("**After deleting one course, student still exists ( but with one less course)");
		Student student1 = session.get(Student.class, id);
		
		System.out.println("**"+student1);
		System.out.println("** Delete student will also delete all the associated courses");
		session.delete(student1);
		
		session.getTransaction().commit();
		
		session.close();
		 
		
		
		
	}
}
