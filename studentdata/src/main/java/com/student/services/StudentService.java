package com.student.services;

import com.student.dao.StudentRepository;
import com.student.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // get all students
    public List<Student> getAllStudents() {
        List<Student> list = (List<Student>) this.studentRepository.findAll();
        return list;
    }

    //get student by id
    public Student getStudentById(int id) {
        Student student = null;
        try {
            student = this.studentRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    //find by year
    public List<Student> getStudentByYear(int year) {
        List<Student> student = null;
        try {
                 student = this.studentRepository.findByYear(year);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    //find by year
//    public List<Student> getStudentByYear(int year) {
//        return studentRepository.findByYear(year);
//    }


    //find by firstName
//    public List<Student> getStudentByFirstName(String firstName)
//    {
//        return studentRepository.findByFirstName(firstName);
//    }

    // find by city name
//    public List<Student> getStudentByCityName(String city) {
//        return studentRepository.findByCity(city);
//    }

    // find by motherName
//    public List<Student> getStudentByMotherName(String motherName) {
//        return studentRepository.findByMotherName(motherName);
//    }

    // add students
    public Student addStudent(Student s) {
        Student result = studentRepository.save(s);
        return s;
    }

    //deleteStudent
    public void deleteStudent(int std) {
        studentRepository.deleteById(std);
    }

    //update student data
    public void updateStudent(Student student, int studentId) {
        student.setId(studentId);
        studentRepository.save(student);
    }

}
