package com.example.agenthibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;




public class App 
{
    
	public static void main( String[] args ) throws Exception
    {
    	
		Agent obj=new  Agent(101,"Satyam","Faridabad",25000);
		Agent obj1=new  Agent(102,"Swayam","Delhi",35000);
		Agent obj2=new  Agent(103,"Varun","Ranchi",15000);
		
		
		Agent obj3=new  Agent(104,"Gaourav","Patna",28000);
    	
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Agent.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	
    	session.save(obj);
    	session.save(obj1);
    	session.save(obj2);
    	session.save(obj3);
    	

    	
    	Query q = session.createQuery("from Alien");
		
		List<Agent> li =  q.list();
		for(Agent aj:li)
		{
			System.out.println(aj);
		}
		
		

		session.getTransaction().commit();
		
		
//		tx.commit();
		

    	session.close();
    
        System.out.println("-----------------Data Saved and Displayed-------------------");
    }
}
