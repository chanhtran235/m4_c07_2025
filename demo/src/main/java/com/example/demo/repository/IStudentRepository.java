package com.example.demo.repository;



import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
 List<Student> findByNameContaining(String name);

 @Query(value = "select * from student where name like :searchName",nativeQuery = true)
 List<Student> searchName(@Param("searchName") String name);

}
