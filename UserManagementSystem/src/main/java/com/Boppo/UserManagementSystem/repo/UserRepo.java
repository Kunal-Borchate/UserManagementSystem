package com.Boppo.UserManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Boppo.UserManagementSystem.dto.UserDto;

public interface UserRepo extends JpaRepository<UserDto,Integer> {

	UserDto findUserByEmailAndPassword(String email,String password);
	
	UserDto findUserByEmail(String email);
	
	
}
