package dev.deol.daos;

import java.util.List;

import dev.deol.entities.Reimbursment;



public interface ReimbursmentDAO {
		//CRUD
		Reimbursment createReimbursment(Reimbursment reimbursment);
		
		Reimbursment getReimbursmentById(int id);
		List<Reimbursment> getReimbursmentsByEmployeeId(int id);
		List<Reimbursment> getReimbursmentsByManagerId(int id);

		List<Reimbursment> getAllReimbursments();
		List<Reimbursment> getCompletedReimbursments();
		List<Reimbursment> getPendingReimbursments();
		
		Reimbursment updateReimbursment(Reimbursment reimbursment);
		
		//boolean deleteReimbursment(Reimbursment reimbursment);

}
