package org.example.demo_thymeleaf.repository;



import jakarta.persistence.TypedQuery;
import org.example.demo_thymeleaf.entity.Student;
import org.example.demo_thymeleaf.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
//        TypedQuery<Student> typedQuery = session.createQuery("from Student",Student.class);
        TypedQuery<Student> typedQuery = session.createNativeQuery("select * from student",Student.class);
        studentList = typedQuery.getResultList();
        session.close();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
//        TypedQuery<Student> typedQuery = session.createQuery("from Student",Student.class);
//        TypedQuery<Student> typedQuery = session.createNativeQuery("select * from student where id = :id",Student.class);
//        typedQuery.setParameter("id",id);
//        return typedQuery.getSingleResult();
        return session.find(Student.class,id);
    }

    @Override
    public boolean add(Student student) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.save(student);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        Student deleteStudent = findById(id);
        if (deleteStudent!=null){
            transaction.begin();
            session.remove(deleteStudent);
            transaction.commit();
        }
        return false;
    }
}
