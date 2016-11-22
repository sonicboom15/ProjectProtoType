package com.rishi.springmvc.controller;

import java.util.List;
import java.util.Locale;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rishi.springmvc.model.Student;
import com.rishi.springmvc.service.StudentService;

@Controller
@RequestMapping("/")
public class AppController {
 
    @Autowired
    StudentService service;
     
    @Autowired
    MessageSource messageSource;
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listStudents(ModelMap model) {
    	 
        List<Student> students = service.findAllStudent();
        model.addAttribute("students", students);
        return "allstudents";
    }
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newStudent(ModelMap model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("edit", false);
        return "registration";
    }
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveStudent(@Valid Student student, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
        
        if(!service.isStudentrollnoUnique(student.getId(), student.getrollno())){
            FieldError rollnoError =new FieldError("student","rollno",messageSource.getMessage("non.unique.rollno", new String[]{student.getrollno()}, Locale.getDefault()));
            result.addError(rollnoError);
            return "registration";
        }
        service.saveStudent(student);
        model.addAttribute("success", "Student " + student.getName() + " registered successfully");
        return "success";
    }
    @RequestMapping(value = { "/edit-{rollno}-student" }, method = RequestMethod.GET)
    public String editStudent(@PathVariable String rollno, ModelMap model) {
        Student student = service.findStudentByrollno(rollno);
        model.addAttribute("student", student);
        model.addAttribute("edit", true);
        return "registration";
    }
    @RequestMapping(value = { "/edit-{rollno}-student" }, method = RequestMethod.POST)
    public String updateStudent(@Valid Student student, BindingResult result,
            ModelMap model, @PathVariable String rollno) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.isStudentrollnoUnique(student.getId(), student.getrollno())){
            FieldError rollnoError =new FieldError("student","rollno",messageSource.getMessage("non.unique.rollno", new String[]{student.getrollno()}, Locale.getDefault()));
            result.addError(rollnoError);
            return "registration";
        }
 
        service.updateStudent(student);
 
        model.addAttribute("success", "Student " + student.getName()  + " updated successfully");
        return "success";
    }
    @RequestMapping(value = { "/delete-{rollno}-student" }, method = RequestMethod.GET)
    public String deleteStudent(@PathVariable String rollno) {
        service.deleteStudentByrollno(rollno);
        return "redirect:/list";
    }
     
}

    