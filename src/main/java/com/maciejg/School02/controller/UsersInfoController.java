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

import com.maciejg.School02.repository.LoginRepository;
import com.maciejg.School02.repository.StudentsTeachersRepository;
import com.maciejg.School02.exception.ResourceNotFoundException;
import com.maciejg.School02.model.StudentsTeachersEntity;

@RestController
@CrossOrigin
@RequestMapping("/secretary")
public class UsersInfoController {

	@Autowired
	StudentsTeachersRepository studentsTeachersRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping("/users")
	public List<StudentsTeachersEntity> getAll(){
		return studentsTeachersRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public StudentsTeachersEntity getById(@PathVariable(value = "id") long id) {
		
		return studentsTeachersRepository.findById(id)
				.orElseThrow(() -> new  ResourceNotFoundException("Info", "Id", id));
	}
	
	@PostMapping("/users")
	public StudentsTeachersEntity createUser(@Valid @RequestBody StudentsTeachersEntity entity) {
		
		return studentsTeachersRepository.save(entity);
	}
	
	@PutMapping("/users/{id}")
	public StudentsTeachersEntity updateUser(@PathVariable(value = "id") long id,
											@Valid @RequestBody StudentsTeachersEntity entity) {
		
		StudentsTeachersEntity studentsTeachersEntity = studentsTeachersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("UsersEntity", "id", id));
	
	studentsTeachersEntity.setName(entity.getName());
	studentsTeachersEntity.setSurname(entity.getSurname());
	studentsTeachersEntity.setPesel(entity.getPesel());
	studentsTeachersEntity.setPhoneNumber(entity.getPhoneNumber());
	studentsTeachersEntity.setAddress(entity.getAddress());
	studentsTeachersEntity.setEmail(entity.getEmail());
	studentsTeachersEntity.setEnglish_group(entity.getEnglish_group());
	
	StudentsTeachersEntity updated = studentsTeachersRepository.save(studentsTeachersEntity);
	
	return updated;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") long id){
		StudentsTeachersEntity entity = studentsTeachersRepository
									.findById(id)
									.orElseThrow(() -> new ResourceNotFoundException("UsersEntity", "id", id));
		studentsTeachersRepository.delete(entity);
		
		return ResponseEntity.ok().build();
	}
	
}
