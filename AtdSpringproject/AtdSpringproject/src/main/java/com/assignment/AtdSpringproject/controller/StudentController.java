package com.assignment.AtdSpringproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.AtdSpringproject.dto.Students;
import com.assignment.AtdSpringproject.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repo;

	//Insert data into Students table
	@PostMapping("/savestudent")
	public String saveStudent(@RequestBody Students students) {
		repo.save(students);
		return "Data Saved!!";
	}
	
	//Fetch single data from table
	@GetMapping("/fetchstudent")
	public Students getStudent(@RequestParam int id) {
		
		Optional<Students> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	//Fetch All data from table
	@GetMapping("/fetchstudents")
	public List<Students> getallStudents(){
		return repo.findAll();
	}
	
	//Update multiple data 
	@PutMapping("/updatestudent")
	public Students updateStudent(@RequestParam int id,@RequestBody Students students) {
		
		Optional<Students> optional = repo.findById(id);
		if(optional.isPresent()) {
			students.setId(id);
			return repo.save(students);
			
		}
		return null;
	}
	
	//Update a single data
	@PatchMapping("/updateemail")
	public Students updateEmail(@RequestParam int id, @RequestParam String email) {
		Optional<Students> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			Students students = optional.get();
			students.setEmail(email);
			return repo.save(students);
		}
		return null;
	}
	
	//Delete data from table
	@DeleteMapping("/removestudent")
	public String removeStudent(@RequestParam int id) {
		Optional<Students> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			repo.deleteById(id);
			return "Data Removed Successfully!!";
		}
		return "Data Not Found!!";
		
	}



}
