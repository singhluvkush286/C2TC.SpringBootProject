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
public class CertificateController {
	
	@Autowired
	private CertificateService service;
	
	// Retrieval  Certificate
	@GetMapping("/certificate/get")
	public List<Certificate> list() {
		return service.listAll();
	}
	
	// Retrieve Certificate By id
	@GetMapping("/certificate/getbyid/{id}")
	public ResponseEntity<Certificate> get(@PathVariable Integer id) {
		try {
			Certificate certificate = service.get(id);
			return new ResponseEntity<>(certificate, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Add Certificate
	@PostMapping("/certificate/add")
	public ResponseEntity<?> add(@RequestBody Certificate certificate) {
		service.save(certificate);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// Update Certificate Details
	@PutMapping("/certificate/update/{id}")
	public ResponseEntity<?> update(@RequestBody Certificate certificate, @PathVariable Integer id) {
		try {
			Certificate existCertificate = service.get(id);
			service.save(certificate);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete Certificate
	@DeleteMapping("/certificate/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
