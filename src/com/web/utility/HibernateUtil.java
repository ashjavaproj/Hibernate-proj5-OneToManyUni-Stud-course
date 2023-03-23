package com.web.utility;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.web.model.Course;
import com.web.model.Student;




public class HibernateUtil {
	public static StandardServiceRegistry registry;
	public static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
	       Map<Object, String> config=new HashMap<Object, String>();
	      
	       //Connection properties
	       config.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	       config.put(Environment.URL,"jdbc:mysql://localhost:3306/webdb");
	       config.put(Environment.USER, "root");
	       config.put(Environment.PASS, "root"); 
	       
	       //Hibernate Properties
	       config.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");//for auto query genration feature
	       config.put(Environment.HBM2DDL_AUTO, "update"); // for auto table creation feature//HBM2DDL_AUTO=Hiberate Mapping to Data Defination Languale
	       config.put(Environment.SHOW_SQL, "true"); //  to print query which is create by hibernate
	       
	       registry=new StandardServiceRegistryBuilder().applySettings(config).build();
	      
	       MetadataSources mds=new MetadataSources(registry);
	        
	       mds.addAnnotatedClass(Student.class);
	       mds.addAnnotatedClass(Course.class);
	       Metadata md=mds.getMetadataBuilder().build();
	       
	       sessionFactory=md.getSessionFactoryBuilder().build();
	       
	       return sessionFactory;
		}
		return sessionFactory;
	}

}



