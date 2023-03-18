package com.hibernate1;

import com.hibernate1.dao.DBSession;

public class Main {

	public static void main(String args[]) {

	
		DBSession dbSession = DBSession.getDBSession();
		
		dbSession.run();
	}
}
