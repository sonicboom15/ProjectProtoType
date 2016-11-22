package com.rishi.springmvc.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.rishi.springmvc.dao.StudentDao;
import com.rishi.springmvc.model.Student;
 
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
 
    @Autowired
    private StudentDao dao;
     
    public Student findById(int id) {
        return dao.findById(id);
    }
 
    public void saveStudent(Student student) {
        dao.saveStudent(student);
    }
    public void updateStudent(Student student) {
        Student entity = dao.findById(student.getId());
        if(entity!=null){
            entity.setName(student.getName());
            entity.setdob(student.getdob());
            entity.setregisterno(student.getregisterno());
            entity.setrollno(student.getrollno());
        }
    }
 
    public void deleteStudentByrollno(String rollno) {
        dao.deleteStudentByrollno(rollno);
    }
     
    public List<Student> findAllStudent() {
        return dao.findAllStudent();
    }
 
    public Student findStudentByrollno(String rollno) {
        return dao.findStudentByrollno(rollno);
    }
 
    public boolean isStudentrollnoUnique(Integer id, String rollno) {
        Student student = findStudentByrollno(rollno);
        return ( student == null || ((id != null) && (student.getId() == id)));
    }
     
}