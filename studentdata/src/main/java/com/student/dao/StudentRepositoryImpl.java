//package com.student.dao;
//
//import com.student.entities.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//public class StudentRepositoryImpl implements StudentRepositoryImp {
//
//    @Autowired
//
//    @Override
//    public List<Student> findByFirstName(String firsName) {
//        String sql = "select e from Student e where e.year=:year";
//        final TypedQuery<Student> query = entityManager.createQuery(sql, Student.class);
//        query.setParameter("firstName", firsName);
//        return query.getResultList();
//
//
//    }
//}
