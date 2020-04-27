package dev.deol.entities;

public class Employee {
	private int eId;
	
	private String name;
	private String username;
	private String password;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	public Employee(int eId, String name) {
		super();
		this.eId = eId;
		this.name = name;
	}


	public int geteId() {
		return eId;
	}


	public void seteId(int eId) {
		this.eId = eId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
	

	
	
}
