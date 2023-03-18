package com.hibernate5;

import com.hibernate5.dao.DBSession;

public class Main {

	public static void main(String args[]) {
		DBSession.getDBConnection().run();
	}
}
