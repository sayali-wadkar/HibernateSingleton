package com.prowings.hibernate.singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateAPI {

	private static SessionFactory factory = null;
	
	public static SessionFactory getFactory() {
		
		if(factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
	
	
	public static void main(String[] args) {
		
		Employee emp = new Employee(1,"sayali",560.45);
		Employee emp1 = new Employee(2,"Arati",650.75);
		Employee emp2 = new Employee(3,"komal",765.45);
		Employee emp3 = new Employee(4,"jyoti",843.65);
		Employee emp4= new Employee(5,"dipali",864.15);
		
		try(SessionFactory factory = getFactory();Session session = factory.openSession()) 
		{
	
			Transaction tx = session.beginTransaction();
			
			session.save(emp);
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			
			tx.commit();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
