package org.example.demo_spring_mvc.repository;



import org.example.demo_spring_mvc.entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh",true,List.of("JAVA", "PHP","SQL","HTML"),"C07"));
        studentList.add(new Student(2,"chánh2",true,List.of("JAVA", "PHP","SQL"),"C07"));
        studentList.add(new Student(3,"chánh3",true,List.of("JAVA", "PHP"),"C07"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        for(Student student : studentList){
            if (student.getId()==id){
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
