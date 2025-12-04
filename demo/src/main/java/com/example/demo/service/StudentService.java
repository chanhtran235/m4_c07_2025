package com.example.demo.service;


import com.example.demo.entity.ClassCG;
import com.example.demo.entity.Student;
import com.example.demo.repository.IClassRepository;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IClassRepository classRepository;
    @Override
    public List<Student> findAll() {
        String searchName = "t";
        ClassCG classCG = classRepository.findById(1).orElse(null);
        return studentRepository.searchName("%"+searchName+"%");
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.save(student)!=null;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            studentRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
