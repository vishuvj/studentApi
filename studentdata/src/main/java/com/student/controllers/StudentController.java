package com.student.controllers;

import com.student.dao.StudentRepository;
import com.student.entities.Student;
import com.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    // get all student handler
    @GetMapping("/students")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudents() {

        List<Student> list = studentService.getAllStudents();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }


    //findById handler
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(student));
    }


    //find by year
    @GetMapping("/students?year=={year}")
    public ResponseEntity<List<Student>> findByYear(@RequestParam(value = "year") int year) {
        List<Student> student = studentService.getStudentByYear(year);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(student));
    }

    // find by year handler
//    @GetMapping("/students?year=={year}")
//    public List<Student> getStudentByYear(@RequestParam(value = "year") int year) {
//        return studentService.getStudentByYear(year);
//    }

    //find  student by cityName
//    @GetMapping("/students?city=={city}")
//    public List<Student> getStudentByCityName(@RequestParam(value = "city") String city) {
//        return studentService.getStudentByCityName(city);
//    }

    //find student by motherName handler
//    @GetMapping("/students/")
//    public List<Student> getStudentByMotherName(@RequestParam(value = "mother") String motherName)
//    {
//        return studentService.getStudentByMotherName(motherName);
//    }

    //add students
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student s = null;
        try {
            s = this.studentService.addStudent(student);
//        System.out.println(student);
            return ResponseEntity.of(Optional.of(s));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //delete student handler

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") int studentId) {
        try {
            this.studentService.deleteStudent(studentId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //update student data
    @PutMapping("/students/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("studentId") int studentId) {
        try {
            this.studentService.updateStudent(student, studentId);
            return ResponseEntity.ok().body(student);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
