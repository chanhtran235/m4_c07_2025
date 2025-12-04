package com.example.demo.repository;

import com.example.demo.entity.ClassCG;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClassRepository extends JpaRepository<ClassCG, Integer> {

}
