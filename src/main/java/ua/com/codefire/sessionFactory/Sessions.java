package ua.com.codefire.sessionFactory;

import org.hibernate.Session;

public class Sessions {

	private static Session currentSession = openCurrentSession();

	private static Session openCurrentSession() {
		currentSession = FactorySessions.getSessionFactory().openSession();
		return currentSession;
	}

	public static Session getCurrentSession() {
		return currentSession;
	}

	public static void closeCurrentSession() {
		getCurrentSession().close();
	}
}
