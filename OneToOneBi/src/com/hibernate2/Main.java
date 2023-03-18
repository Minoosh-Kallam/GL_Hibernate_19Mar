package com.hibernate2;

import com.hibernate2.dao.DBSession;

public class Main {

	public static void main(String []args) {
		DBSession dbSession = DBSession.getDBSession();
		
		dbSession.run();
	}
}
