package dev.deol.entities;

public class Reimbursment {
	private int rId;
	private int amount;
	private String description;
	private int eId;
	private int mId;
	private boolean status;
	public Reimbursment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Reimbursment(int rId, int amount, String description, int eId, int mId, boolean status) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.description = description;
		this.eId = eId;
		this.mId = mId;
		this.status = status;
	}


	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status= status;
	}
	
	
	@Override
	public String toString() {
		return "Reimbursment [rId=" + rId + ", amount=" + amount + ", description=" + description + ", eId=" + eId
				+ ", mId=" + mId + ", status=" + status + "]";
	}
	
	
	
}
