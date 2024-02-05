package com.Boppo.UserManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Boppo.UserManagementSystem.dao.UserDao;
import com.Boppo.UserManagementSystem.dto.UserDto;
import com.Boppo.UserManagementSystem.util.ResponseStructure;


@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public ResponseEntity<ResponseStructure<UserDto>> reregisterUser(UserDto dto){
		 ResponseStructure<UserDto>structure=new ResponseStructure<>();
		    structure.setMessage("Registration Successfull ");
		    structure.setStatus(HttpStatus.CREATED.value());
		    structure.setData(dao.registerUser(dto));
		    return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> userLogin(String email,String password){
		
		UserDto dbUser=dao.finduserByEmailAndPassword(email, password);
		
		if(dbUser!=null) {
			ResponseStructure<UserDto>structure=new ResponseStructure<>();
		    structure.setMessage("Login Successfull");
		    structure.setStatus(HttpStatus.OK.value());
		    structure.setData(dao.userLogin(email, password));
		    return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	
	public  ResponseEntity<ResponseStructure<UserDto>> passwordReset(String email,String oldPassword,String newPassword){
		UserDto dbUser=dao.findUserByEmail(email);
		
		if(dbUser!=null) {
			dbUser.setPassword(newPassword);
			ResponseStructure<UserDto>structure=new ResponseStructure<>();
		    structure.setMessage("Password Changed Successfully");
		    structure.setStatus(HttpStatus.OK.value());
		    structure.setData(dao.passwordReset(email, oldPassword, newPassword));
		    return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUsers(){
		List<UserDto>list=dao.findAllUsers();
		ResponseStructure<List<UserDto>> structure=new ResponseStructure<>();
		if (list.isEmpty()) {
			return null;
		}
		else {
			structure.setMessage("Users Found Successfully");
		    structure.setStatus(HttpStatus.FOUND.value());
		    structure.setData(list);
		    return new ResponseEntity(structure,HttpStatus.FOUND);
		}
	}
}
