package com.rishi.springmvc.dao;
 
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.rishi.springmvc.model.Student;
 
@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao {
 
    public Student findById(int id) {
        return getByKey(id);
    }
 
    public void saveStudent(Student student) {
        persist(student);
    }
 
    public void deleteStudentByrollno(String rollno) {
        Query query = getSession().createSQLQuery("delete from Student where rollno = :rollno");
        query.setString("rollno", rollno);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Student> findAllStudent() {
        Criteria criteria = createEntityCriteria();
        return (List<Student>) criteria.list();
    }
 
    public Student findStudentByrollno(String rollno) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("rollno", rollno));
        return (Student) criteria.uniqueResult();
    }
}