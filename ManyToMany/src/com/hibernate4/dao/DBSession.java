package com.hibernate4.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate4.entity.Employee;
import com.hibernate4.entity.Project;

public class DBSession {

	private SessionFactory sessionFactory ;
	
	private static DBSession dbSession ;
	

	private DBSession() {
		sessionFactory = new Configuration().configure("hibernate.config.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Project.class)
				.buildSessionFactory();
	}
	
	public static DBSession getDBConnection() {
		if(dbSession == null)
			dbSession = new DBSession();
		return dbSession ;
	}
	
	
	public void run() {
		Project project1 = new Project("Cloud", new ArrayList<>());
		Employee employee1 = new Employee("Minoosh" , "Software Developer" , new ArrayList<>());
		
		Project project2 = new Project("Support", new ArrayList<>());
		Employee employee2 = new Employee("Minoosh1" , "Software Developer" , new ArrayList<>());
		
		List<Project> list1 = new ArrayList<>();
		List<Employee> list2 = new ArrayList<>();
		
		list1.add(project1);
		list1.add(project2);
		list2.add(employee1);
		list2.add(employee2);
		
		employee1.setProjects(list1);
		project2.setEmployees(list2);
				

				
		Session session = sessionFactory.openSession() ;
		
		session.beginTransaction() ;
		
		session.save(employee1);
		session.save(project2);
		session.save(project1);
		session.save(employee2);

		
		session.getTransaction().commit();
		
		session.close();
		
		
		System.out.println("*** Fetching all projects assigned to an employeeid "+employee1.getId());
		session = sessionFactory.openSession();
		session.beginTransaction() ;
		Employee employee = session.get(Employee.class, employee1.getId());
		System.out.println("*** ");
		employee.getProjects().stream().forEach(project -> System.out.println(project.getProjectName()));
		System.out.println("*** ");
		
		System.out.println("\n*** Fetching all employees assigned to a project "+project1.getId());
		Project project = session.get(Project.class, project1.getId());
		System.out.println("*** ");
		project.getEmployees().forEach(emp -> System.out.println(emp.getName()));
		System.out.println("*** ");
		session.getTransaction().commit();
		session.close();
		
		
		
		
		
	}
}
