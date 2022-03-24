package com.motivity;

import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainMethod {
	public static void main(String[] args){
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hib2.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		Employer empr1=new Employer();
		empr1.setEmployer_id(1);
		empr1.setEmployer_name("Anusha");
		empr1.setEmployer_mobile(9731071165l);
		empr1.setEmployer_department("IT");
		
		Employer empr2=new Employer();
		empr2.setEmployer_id(5);
		empr2.setEmployer_name("Samhitha");
		empr2.setEmployer_mobile(8074178155l);
		empr2.setEmployer_department("Finance");
		
		Employer empr3=new Employer();
		empr3.setEmployer_id(3);
		empr3.setEmployer_name("Rahul");
		empr3.setEmployer_mobile(965483726l);
		empr3.setEmployer_department("Market");
	
		Employee emp1=new Employee();
		emp1.setEmployee_id(7);
		emp1.setEmployee_name("Karthik");
		emp1.setEmployee_mobile(9912165235l);
		emp1.setEmployee_address("vizag");
		emp1.setEmployer(empr1);
		
		Employee emp2=new Employee();
		emp2.setEmployee_id(9);
		emp2.setEmployee_name("Varsha");
		emp2.setEmployee_mobile(9912367524l);
		emp2.setEmployee_address("Hyderabad");
		emp2.setEmployer(empr2);
		
		Employee emp3=new Employee();
		emp3.setEmployee_id(10);
		emp3.setEmployee_name("aruna kumari");
		emp3.setEmployee_mobile(9912376543l);
		emp3.setEmployee_address("Banglore");
		emp3.setEmployer(empr3);
		
		Employee emp4=new Employee();
		emp4.setEmployee_id(11);
		emp4.setEmployee_name("krishna Sai");
		emp4.setEmployee_mobile(9932124615l);
		emp4.setEmployee_address("Chennai");
		emp4.setEmployer(empr3);
		
	
		List<Employee> al1=new ArrayList<Employee>();
		al1.add(emp1);
		//empr1.setEmployee(al1);
		
		List<Employee> al2=new ArrayList<Employee>();
		al2.add(emp2);
		//al2.add(emp3);
		//empr2.setEmployee(al2);
		
		List<Employee> al3=new ArrayList<Employee>();
	//	empr3.setEmployee(al3);
		//empr3.setEmployee(al3);
		
		al3.add(emp3);
		al3.add(emp4);
		empr1.setEmployee(al1);
		empr2.setEmployee(al2);
		empr3.setEmployee(al3);
		session.save(empr1);
		session.save(empr2);
		session.save(empr3);
		session.save(emp1);
		session.save(emp2);
		
		session.save(emp3);
		session.save(emp4);
		
		t.commit();
		session.close();
	}

}