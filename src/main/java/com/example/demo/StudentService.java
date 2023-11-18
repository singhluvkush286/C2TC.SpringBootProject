package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service 
@Transactional
public class StudentService {
    
    @Autowired
    private StudentRepository repository;
    
    public List<Student> listAll(){
        return repository.findAll();
    }
    
    public Student get(Integer id) {
        return repository.findById(id).orElse(null);
    }
    
    public void save(Student student) {
        repository.save(student);
    }
    
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
