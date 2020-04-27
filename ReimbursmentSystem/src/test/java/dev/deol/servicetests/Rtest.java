package dev.deol.servicetests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.deol.daos.EmployeeDAO;
import dev.deol.daos.EmployeeDAOmariadb;
import dev.deol.daos.ReimbursmentDAO;
import dev.deol.daos.ReimbursmentDAOmariadb;
import dev.deol.entities.Employee;
import dev.deol.entities.Reimbursment;
import dev.deol.services.ReimbursmentService;
import dev.deol.services.ReimbursmentServiceImpl;

public class Rtest {
	
	private ReimbursmentDAO rdao= new ReimbursmentDAOmariadb();
	ReimbursmentService rserv= new ReimbursmentServiceImpl();
	EmployeeDAO edao= new EmployeeDAOmariadb();
	
	@Test
	public void test() {
		Reimbursment r = new Reimbursment(0,600, "songekrf",1,1, false);
		rdao.createReimbursment(r);
		System.out.println(r);
		
	}
	
	@Test
	public void test2() {
		Reimbursment r = rserv.getReimbursmentById(2);
		System.out.println(r);
		rserv.maskReimbursmentComplete(r);
		//System.out.println(r);

	}
	
	@Test
	public void test3() {
		//Employee e= new Employee("JATT","PASSWORD");
		Employee e=edao.login("JATT", "PASSWORD");
		System.out.println(e);

	}
	
	@Test
	public void test4() {
		//Employee e= new Employee("JATT","PASSWORD");
		List<Reimbursment> r = rserv.retrieveAllReimbursmentsByEId(1);
		
		
		System.out.println(r+"n");

	}
	
	@Test
	public void test5() {
		
		List<Reimbursment> r = rserv.retrieveAllReimbursmentsByMId(1);
		
		
		System.out.println(r);

	}

}
