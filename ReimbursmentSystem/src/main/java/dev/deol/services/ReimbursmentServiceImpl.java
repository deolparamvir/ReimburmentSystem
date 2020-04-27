package dev.deol.services;

import java.util.List;

import dev.deol.daos.ReimbursmentDAO;
import dev.deol.daos.ReimbursmentDAOmariadb;
import dev.deol.entities.Reimbursment;

public class ReimbursmentServiceImpl implements ReimbursmentService{
	
	private ReimbursmentDAO rdao = new ReimbursmentDAOmariadb();
	
	@Override
	public Reimbursment createReimbursment(Reimbursment reimbursment) {
		// TODO Auto-generated method stub
		rdao.createReimbursment(reimbursment);
		return reimbursment;
	}

	@Override
	public Reimbursment maskReimbursmentComplete(Reimbursment reimbursment) {
		// TODO Auto-generated method stub
		reimbursment.setStatus(true);
		rdao.updateReimbursment(reimbursment);
		return reimbursment;
	}

	@Override
	public Reimbursment getReimbursmentById(int id) {
		// TODO Auto-generated method stub
		return rdao.getReimbursmentById(id);
	}

	@Override
	public List<Reimbursment> retrieveAllReimbursments() {
		// TODO Auto-generated method stub
		return rdao.getAllReimbursments();
	}

	@Override
	public List<Reimbursment> retrievePendingReimbursments() {
		// TODO Auto-generated method stub
		return rdao.getPendingReimbursments();
	}

	@Override
	public List<Reimbursment> retrieveCompletedReimbursments() {
		// TODO Auto-generated method stub
		return rdao.getCompletedReimbursments();
	}

	@Override
	public List<Reimbursment> retrieveAllReimbursmentsByEId(int id) {
		// TODO Auto-generated method stub
		return rdao.getReimbursmentsByEmployeeId(id);
	}

	@Override
	public List<Reimbursment> retrieveAllReimbursmentsByMId(int id) {
		// TODO Auto-generated method stub
		return rdao.getReimbursmentsByManagerId(id);
	}

}
