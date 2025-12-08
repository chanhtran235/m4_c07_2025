package com.example.demo.service;



import com.example.demo.entity.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(String name, Pageable pageable);
    Student findById(int id);
    boolean add(Student student);
    boolean deleteById(int id);

}
