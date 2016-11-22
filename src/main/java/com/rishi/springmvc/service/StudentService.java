package com.rishi.springmvc.service;

import java.util.List;

import com.rishi.springmvc.model.Student;
 
public interface StudentService {
 
    Student findById(int id);
     
    void saveStudent(Student student);
     
    void updateStudent(Student student);
     
    void deleteStudentByrollno(String rollno);
 
    List<Student> findAllStudent(); 
     
    Student findStudentByrollno(String rollno);
 
    boolean isStudentrollnoUnique(Integer id, String rollno);
     
}