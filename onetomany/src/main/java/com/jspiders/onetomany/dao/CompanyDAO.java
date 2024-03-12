package com.jspiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.CompanyDTO;
import com.jspiders.onetomany.dto.EmployeeDTO;

public class CompanyDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
public static void main(String[] args) {
	CompanyDTO company=new CompanyDTO();
	company.setName("Tata");
	company.setLocation("Pune");
	
	EmployeeDTO employee1=new EmployeeDTO();
	employee1.setName("Ajay");
	employee1.setEmail("ajay@gmail.com");
	employee1.setMobile(9096456787l);
	
	
	EmployeeDTO employee2=new EmployeeDTO();
	employee2.setName("Vijay");
	employee2.setEmail("vijay@gmail.com");
	employee2.setMobile(8096456787l);

	
	EmployeeDTO employee3=new EmployeeDTO();
	employee3.setName("Sanjay");
	employee3.setEmail("sanjay@gmail.com");
	employee3.setMobile(7096456787l);
	
	EmployeeDTO employee4=new EmployeeDTO();
	employee4.setName("Digvijay");
	employee4.setEmail("digvijay@gmail.com");
	employee4.setMobile(6096456787l);

List<EmployeeDTO> employees=new ArrayList<EmployeeDTO>();
employees.add(employee1);
employees.add(employee2);
employees.add(employee3);
employees.add(employee4);

company.setEmployees(employees);
	openConnection();
	entityTransaction.begin();
	entityManager.persist(employee1);
	entityManager.persist(employee2);
	entityManager.persist(employee3);
	entityManager.persist(employee4);
    entityManager.persist(company);
	entityTransaction.commit();
	closeConnection();
}
private static void openConnection() {
	entityManagerFactory=Persistence.createEntityManagerFactory("company");
	entityManager=entityManagerFactory.createEntityManager();
	entityTransaction=entityManager.getTransaction();
}
private static void closeConnection() {
	if(entityManagerFactory!=null) {
		entityManagerFactory.close();
	}
	if(entityManager!=null) {
		entityManager.close();
	}
	if(entityTransaction!=null) {
		if(entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}
}

}
