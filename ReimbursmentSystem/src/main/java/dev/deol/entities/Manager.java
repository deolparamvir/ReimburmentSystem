package dev.deol.entities;

public class Manager {
	private int mId;
	
	private String name;
	private String username;
	private String password;
	
	
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Manager(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

	public Manager(int mId, String name) {
		super();
		this.mId = mId;
		this.name = name;
	}


	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
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
		return "Manager [mId=" + mId + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
