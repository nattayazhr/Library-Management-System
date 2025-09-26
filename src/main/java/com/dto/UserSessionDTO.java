package com.dto;

public class UserSessionDTO {
	private int user_id;
	private String user_name;
	private String role;
	
	public UserSessionDTO(int user_id, String user_name, String role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserSessionDTO [user_id=" + user_id + ", user_name=" + user_name + ", role=" + role + "]";
	}
	
}
