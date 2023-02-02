package com.bitlabs.sampleprojectonhibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "project started" );
        SessionFactory factory=null;
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
       
        factory=cfg.buildSessionFactory();
       // System.out.println(factory);
      //  System.out.println(factory.isClosed());
        if(factory!=null)
        {
        	System.out.println("success");
        }
        org.hibernate.Session session=factory.openSession();  //delete, insert, update
         Transaction txn=session.beginTransaction();
        Student st=new Student();
        st.setId(101);
        st.setName("sowjanya");
        st.setCity("vijayawada");
        session.save(st);
        txn.commit();
        session.close();
        
        
        
    }
}
