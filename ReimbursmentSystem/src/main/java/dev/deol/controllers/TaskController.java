package dev.deol.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.deol.daos.EmployeeDAO;
import dev.deol.daos.EmployeeDAOmariadb;
import dev.deol.daos.ReimbursmentDAO;
import dev.deol.daos.ReimbursmentDAOmariadb;
import dev.deol.entities.Employee;
import dev.deol.entities.Reimbursment;
import dev.deol.services.ReimbursmentService;
import dev.deol.services.ReimbursmentServiceImpl;

public class TaskController {
	
	ReimbursmentService rserv= new ReimbursmentServiceImpl();
	ReimbursmentDAO rdao= new ReimbursmentDAOmariadb();
	EmployeeDAO edao= new EmployeeDAOmariadb();

	public void getAllReimbursments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		List<Reimbursment> reimbursments = rserv.retrieveAllReimbursments();  
		PrintWriter pw = response.getWriter();
		
		String json = gson.toJson(reimbursments);
		pw.append(json);
		
	}
	
	public void getAllReimbursmentsByEID(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		String body= request.getReader().lines().reduce("", (accumulator,actual)-> accumulator+actual);
		//Employee e= edao.login(username, password);
		//int id= ;
		List<Reimbursment> reimbursments = rserv.retrieveAllReimbursmentsByEId(1);  
		PrintWriter pw = response.getWriter();
		
		String json = gson.toJson(reimbursments);
		pw.append(json);
		
	}
	
	public void getAllReimbursmentsByMID(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		String body= request.getReader().lines().reduce("", (accumulator,actual)-> accumulator+actual);
		List<Reimbursment> reimbursments = rserv.retrieveAllReimbursmentsByMId(1);  
		PrintWriter pw = response.getWriter();
		
		String json = gson.toJson(reimbursments);
		pw.append(json);
		
	}
	
	
	//when you add information you want to send it in the body
	public void addReimbursment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body= request.getReader().lines().reduce("", (accumulator,actual)-> accumulator+actual);
		Gson gson = new Gson();
		//Employee e= ;
		Reimbursment reimbursment = gson.fromJson(body, Reimbursment.class);
		rdao.createReimbursment(reimbursment);
		//rserv.createReimbursment(reimbursment);
		response.getWriter().append("Added Reimbursment");
		
	}
	
	public void pendingReimbursments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(rserv.retrievePendingReimbursments());
		response.getWriter().append(json);
		

	}
	
	public void completedReimbursments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(rserv.retrieveCompletedReimbursments());
		response.getWriter().append(json);
		

	}
	public void updateReimbursment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce("", (accumulator,actual)-> accumulator+actual);
		Reimbursment reimbursment = gson.fromJson(json, Reimbursment.class);
		rserv.maskReimbursmentComplete(reimbursment);
		response.getWriter().append("successfully updated Reimbursment!!!!!");
		
	}
	
	
	
	
}
