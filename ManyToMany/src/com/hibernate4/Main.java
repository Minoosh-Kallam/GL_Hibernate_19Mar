package com.hibernate4;

import com.hibernate4.dao.DBSession;

public class Main {

	public static void main(String args[]) {
		DBSession.getDBConnection().run();
	}
}
