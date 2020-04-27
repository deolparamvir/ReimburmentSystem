package dev.deol.services;

import java.util.List;

import dev.deol.entities.Reimbursment;



public interface ReimbursmentService {
	
	
	Reimbursment createReimbursment(Reimbursment reimbursment);
	Reimbursment maskReimbursmentComplete(Reimbursment reimbursment);
	Reimbursment getReimbursmentById(int id);
	
	List<Reimbursment> retrieveAllReimbursmentsByEId(int id);
	List<Reimbursment> retrieveAllReimbursmentsByMId(int id);

	List<Reimbursment> retrieveAllReimbursments();
	List<Reimbursment> retrievePendingReimbursments();
	List<Reimbursment> retrieveCompletedReimbursments();
	
	
}
