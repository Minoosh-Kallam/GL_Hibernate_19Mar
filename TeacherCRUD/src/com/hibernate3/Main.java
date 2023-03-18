package com.hibernate3;

import com.hibernate3.dao.DBSession;
import com.hibernate3.entity.Teacher;

public class Main {

	public static void main(String []args) {
		
		DBSession dbSession = DBSession.getDBConnection() ;
		
		Teacher teacher ;
		
		// saving new teacher 
		System.out.println("*** Saving new Neacher ***");
		teacher = new Teacher("Sachin" , "Sharma" , "Sachin.Sharma@gmail.com");
		teacher = dbSession.addTeacher(teacher);
		System.out.println("*** New Teacher saved "+teacher+" ***");
		
		//getting the Teacher
		System.out.println("*** Getting teacher details by id***");
		int id = teacher.id;
		teacher = dbSession.getTeacher(id);
		System.out.println("*** teacher with id is "+teacher+" ***");
		
		//updating teacher
		System.out.println("*** Updating teacher details");
		System.out.println("*** teacher details before updation "+teacher+" ***");
		teacher = new Teacher(id , "kapil", "Sharma" , "Kapil.Sharma@gmail.com" );
		System.out.println("*** teacher details after updation "+teacher+" ***");
		
		//deleteing the teacher
		System.out.println("Deleting teacher by id");
		System.out.println("*** before deletion the teacher is "+ dbSession.getTeacher(id)+" ***") ;
		dbSession.deleteTeacher(teacher.id);
		System.out.println("*** after deletion the teacher is "+ dbSession.getTeacher(id)+" ***") ;
		
		
		
		
		
		
	}
}
