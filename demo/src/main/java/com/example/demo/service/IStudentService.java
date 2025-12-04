package com.example.demo.service;



import com.example.demo.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);
    boolean deleteById(int id);

}
