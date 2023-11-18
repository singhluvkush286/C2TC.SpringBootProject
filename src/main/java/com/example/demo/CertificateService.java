package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public class CertificateService {
	
	@Autowired
    private CertificateRepository repository;
    
    public List<Certificate> listAll(){
        return repository.findAll();
    }
    
    public Certificate get(Integer id) {
        return repository.findById(id).orElse(null);
    }
    
    public void save(Certificate student) {
        repository.save(student);
    }
    
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
