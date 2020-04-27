package dev.deol.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.deol.entities.Reimbursment;
import dev.deol.services.ReimbursmentService;
import dev.deol.services.ReimbursmentServiceImpl;

public class EmployeeController {
	
	
	ReimbursmentService rserv= new ReimbursmentServiceImpl();

	public void getAllReimbursments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		List<Reimbursment> reimbursments = rserv.retrieveAllReimbursments();  
		PrintWriter pw = response.getWriter();
		
		String json = gson.toJson(reimbursments);
		pw.append(json);
		
	}
	
	
	//when you add information you want to send it in the body
	public void addReimbursment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body= request.getReader().lines().reduce("", (accumulator,actual)-> accumulator+actual);
		Gson gson = new Gson();
		
		//when you turn a json into an object you have to tell it what type of object to turn it into
		Reimbursment reimbursment = gson.fromJson(body, Reimbursment.class);
		rserv.createReimbursment(reimbursment);
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
}
