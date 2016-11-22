package com.rishi.springmvc.dao;
 
import java.util.List;
 
import com.rishi.springmvc.model.Student;
 
public interface StudentDao {
 
    Student findById(int id);
 
    void saveStudent(Student student);
     
    void deleteStudentByrollno(String rollno);
     
    List<Student> findAllStudent();
 
    Student findStudentByrollno(String rollno);
 
}