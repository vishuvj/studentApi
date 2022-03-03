package com.student.dao;

import com.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Collectors;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findById(int id);
//    @Query("select s From  Student s where s.year =: year")
//    public List<Student> getStudentByYear(@Param("year") int year);

    public List<Student> findByCity(String city);

    public List<Student> findByYear(int year);

//    public List<Student> findByMotherName(String motherName);

    @Query("select s FROM Student s where s.motherName =:s")
    public List<Student> getStudentByMotherName(@Param("s") String motherName);
}
