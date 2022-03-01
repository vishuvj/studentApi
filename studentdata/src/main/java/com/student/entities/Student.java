package com.student.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.stream.DoubleStream;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "first_Name",length = 30)
    private String firstName;

    @Column(name = "last_Name",length = 30)
    private String lastName;

    @Column(name = "email",length = 30)
    private String email;

    @Column(name = "father_Name",length = 30)
    private String fatherName;

    @Column(name = "mother_Name",length = 30)
    private String motherName;

    @Column(name = "class_Name")
    private int className;

    @Column(name = "year")
    private int year;

    @Column(name = "city")
    private String city;

    public Student(int id, String firstName, String lastName, String email, String fatherName,
                   String motherName, int className, int year, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.className = className;
        this.year = year;
        this.city = city;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public int getClassName() {
        return className;
    }

    public void setClassName(int className) {
        this.className = className;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", className=" + className +
                ", year=" + year +
                ", city='" + city + '\'' +
                '}';
    }

}
