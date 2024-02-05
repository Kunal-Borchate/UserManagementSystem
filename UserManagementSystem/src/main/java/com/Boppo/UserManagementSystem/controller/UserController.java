package com.Boppo.UserManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Boppo.UserManagementSystem.dto.UserDto;
import com.Boppo.UserManagementSystem.service.UserService;
import com.Boppo.UserManagementSystem.util.ResponseStructure;

@org.springframework.web.bind.annotation.RestController
public class UserController {

	@Autowired
	private UserService service;
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<UserDto>> reregisterUser(@RequestBody UserDto dto){
		 return service.reregisterUser(dto);
	}
	
	@GetMapping("/login")
    public ResponseEntity<ResponseStructure<UserDto>> userLogin(@RequestParam String email,@RequestParam String password){
		
		return service.userLogin(email, password);
	}
	
	@PutMapping("/passReset")
	public  ResponseEntity<ResponseStructure<UserDto>> passwordReset(@RequestParam String email,@RequestParam String oldPassword,@RequestParam String newPassword){
		
		return service.passwordReset(email, oldPassword, newPassword);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUsers(){
		
		return service.findAllUsers();
	}
}
