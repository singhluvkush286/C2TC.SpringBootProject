package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService service;
	
	// Retrieval  college
	@GetMapping("/college/get")
	public List<College> list() {
		return service.listAll();
	}
	
	// Retrieve college By id
	@GetMapping("/college/getbyid/{id}")
	public ResponseEntity<College> get(@PathVariable Integer id) {
		try {
			College college = service.get(id);
			return new ResponseEntity<>(college, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Create
//	@RequestMapping(method = RequestMethod.POST, )
	@ResponseBody
	@PostMapping(value = "/college/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> add(@RequestBody College college) {
	    service.save(college);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// Update
	@PutMapping("/college/update/{id}")
	public ResponseEntity<?> update(@RequestBody College college, @PathVariable Integer id) {
		try {
			College existCollege = service.get(id);
			service.save(college);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/college/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
