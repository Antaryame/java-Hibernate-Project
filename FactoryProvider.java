package com.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FactoryProvider {
	
	public static SessionFactory factory;
	
	public static SessionFactory getFactory()
	{
		if(factory==null)
		{
			factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		Session session = factory.openSession();
		 Query query = session.createQuery(" from Note");
		
		
		return factory; 
	}
	
	public void closeFactory()
	{
		if(factory.isOpen())
		{
			factory.close();
		}
	}

}
