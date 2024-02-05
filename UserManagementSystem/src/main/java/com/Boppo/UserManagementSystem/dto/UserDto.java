package com.Boppo.UserManagementSystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String userName;
	private String password;
	@Column(unique = true)
	private String email;
	
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}



	public String getUserName() {
		return userName;
	}



	public String getPassword() {
		return password;
	}



	public String getEmail() {
		return email;
	}



	

	public void setId(Integer id) {
		this.id = id;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}



	



	
	
	
	
	
	
	
}
