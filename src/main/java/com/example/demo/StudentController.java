package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	// Retrieval
	@GetMapping("/students/get")
	public List<Student> list() {
		return service.listAll();
	}
	
	// Retrieve By id
	@GetMapping("/students/getbyid/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id) {
		try {
			Student student = service.get(id);
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Create
	@PostMapping("/students/add")
	public ResponseEntity<?> add(@RequestBody Student student) {
		service.save(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// Update
	@PutMapping("/students/update/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id) {
		try {
			Student existStudent = service.get(id);
			service.save(student);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/students/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}

