package org.example.demo_thymeleaf.repository;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.demo_thymeleaf.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("from Student ", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Transactional
    @Override
    public boolean add(Student student) {
        try{
            entityManager.persist(student);
        }catch (Exception e){
            return false;
        }
       return true;
    }

    @Override
    public boolean deleteById(int id) {

        return false;
    }
}
