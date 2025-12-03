package org.example.demo_spring_mvc.repository;



import org.example.demo_spring_mvc.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);
    boolean deleteById(int id);

}
