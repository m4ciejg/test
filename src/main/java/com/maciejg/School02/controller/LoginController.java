package com.maciejg.School02.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maciejg.School02.repository.LoginRepository;
import com.maciejg.School02.exception.ResourceNotFoundException;
import com.maciejg.School02.model.LoginAndPassword;
import com.maciejg.School02.model.StudentsTeachersEntity;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	com.maciejg.School02.repository.LoginRepository loginRepository;
	
	@PostMapping("/login")
	public LoginAndPassword addLoginPassword(@Valid @RequestBody LoginAndPassword entity) {
		System.out.println("New user added to loginAndPassword Entity");
		return loginRepository.save(entity);
	
	}
	
	//get ALL login and password from db
	@GetMapping("/login")
	public List<LoginAndPassword> getAll(){
		
		return loginRepository.findAll();
	}
	
	//get specific login and password from db
	@GetMapping("/login/{id}")
	public LoginAndPassword getById(@PathVariable(value = "id") long id) {
		
		return loginRepository.findById(id)
				.orElseThrow(() -> new  ResourceNotFoundException("Info", "Id", id));
	}
	
}
