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
import com.maciejg.School02.model.Teacher;
import com.maciejg.School02.repository.LoginRepository;
import com.maciejg.School02.repository.TeachersRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TeachersInfoController {

	@Autowired
	TeachersRepository teachersRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping("/teachers")
	public List<Teacher> getAll(){
		return teachersRepository.findAll();
	}
	
	@GetMapping("/teachers/{id}")
	public Teacher getById(@PathVariable(value = "id") long id) {
		
		return teachersRepository.findById(id)
				.orElseThrow(() -> new  ResourceNotFoundException("Info", "Id", id));
	}
	
	@PostMapping("/teachers")
	public Teacher createUser(@Valid @RequestBody Teacher entity) {
		
		return teachersRepository.save(entity);
	}
	
	@PutMapping("/teachers/{id}")
	public Teacher updateUser(@PathVariable(value = "id") long id,
											@Valid @RequestBody Teacher entity) {
		
		Teacher studentsTeachersEntity = teachersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TeachersEntity", "id", id));
	
	studentsTeachersEntity.setName(entity.getName());
	studentsTeachersEntity.setSurname(entity.getSurname());
	studentsTeachersEntity.setPesel(entity.getPesel());
	studentsTeachersEntity.setPhoneNumber(entity.getPhoneNumber());
	studentsTeachersEntity.setAddress(entity.getAddress());
	studentsTeachersEntity.setEmail(entity.getEmail());
	
	Teacher updated = teachersRepository.save(studentsTeachersEntity);
	
	return updated;
	}
	
	@DeleteMapping("/teachers/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") long id){
		Teacher entity = teachersRepository
									.findById(id)
									.orElseThrow(() -> new ResourceNotFoundException("teachersEntity", "id", id));
		teachersRepository.delete(entity);
		
		return ResponseEntity.ok().build();
	}
}
