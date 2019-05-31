package com.maciejg.School02.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maciejg.School02.exception.ResourceNotFoundException;
import com.maciejg.School02.model.Students;
import com.maciejg.School02.model.StudentsTeachersEntity;
import com.maciejg.School02.repository.LoginRepository;
import com.maciejg.School02.repository.StudentsRepository;
import com.maciejg.School02.repository.StudentsTeachersRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentsInfoController {

	@Autowired
	StudentsRepository studentsRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping("/students")
	public List<Students> getAll(){
		return studentsRepository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Students getById(@PathVariable(value = "id") long id) {
		
		return studentsRepository.findById(id)
				.orElseThrow(() -> new  ResourceNotFoundException("Info", "Id", id));
	}
	
	@PostMapping("/students")
	public Students createUser(@Valid @RequestBody Students entity) {
		
		return studentsRepository.save(entity);
	}
	
	@PutMapping("/students/{id}")
	public Students updateUser(@PathVariable(value = "id") long id,
											@Valid @RequestBody Students entity) {
		
		Students studentsTeachersEntity = studentsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("UsersEntity", "id", id));
	
	studentsTeachersEntity.setName(entity.getName());
	studentsTeachersEntity.setSurname(entity.getSurname());
	studentsTeachersEntity.setPesel(entity.getPesel());
	studentsTeachersEntity.setPhoneNumber(entity.getPhoneNumber());
	studentsTeachersEntity.setAddress(entity.getAddress());
	studentsTeachersEntity.setEmail(entity.getEmail());
	studentsTeachersEntity.setEnglish_group(entity.getEnglish_group());
	
	Students updated = studentsRepository.save(studentsTeachersEntity);
	
	return updated;
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") long id){
		Students entity = studentsRepository
									.findById(id)
									.orElseThrow(() -> new ResourceNotFoundException("UsersEntity", "id", id));
		studentsRepository.delete(entity);
		
		return ResponseEntity.ok().build();
	}
}
