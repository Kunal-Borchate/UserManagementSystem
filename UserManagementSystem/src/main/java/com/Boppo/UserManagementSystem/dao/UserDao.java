package com.Boppo.UserManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Boppo.UserManagementSystem.dto.UserDto;
import com.Boppo.UserManagementSystem.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;
	
	
	public UserDto registerUser(UserDto user) {
		
		return repo.save(user);
	}
	
	public UserDto userLogin(String email,String password) {
		return repo.findUserByEmailAndPassword(email, password);
	}
	
	public UserDto passwordReset(String email,String oldPassword,String newPassword) {
		
		
		UserDto dbUser=repo.findUserByEmail(email);
		if(dbUser!=null) {
			dbUser.setPassword(newPassword);
			return repo.save(dbUser);
		}
		return null;
		
	}
	
	public List<UserDto> findAllUsers() {
		return repo.findAll();
	}
	
	public UserDto findUserByEmail(String email) {
		return repo.findUserByEmail(email);
	}
	
	public UserDto finduserByEmailAndPassword(String email,String password) {
		return repo.findUserByEmailAndPassword(email, password);
	}
}
