package org.example.demo_spring_mvc.service;



import org.example.demo_spring_mvc.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);
    boolean deleteById(int id);

}
