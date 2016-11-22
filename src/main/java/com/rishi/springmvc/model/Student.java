package com.rishi.springmvc.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="STUDENT")
public class Student {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Size(min=3, max=50)
    @Column(name = "NAME", nullable = false)
    private String name;
 
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "DOB", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dob;
 
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "REGISTERNO", nullable = false)
    private BigDecimal registerno;
     
    @NotEmpty
    @Column(name = "ROLLNO", unique=true, nullable = false)
    private String rollno;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public LocalDate getdob() {
        return dob;
    }
 
    public void setdob(LocalDate dob) {
        this.dob = dob;
    }
 
    public BigDecimal getregisterno() {
        return registerno;
    }
 
    public void setregisterno(BigDecimal registerno) {
        this.registerno = registerno;
    }
 
    public String getrollno() {
        return rollno;
    }
 
    public void setrollno(String rollno) {
        this.rollno = rollno;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((rollno == null) ? 0 : rollno.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Student))
            return false;
       Student other = (Student) obj;
        if (id != other.id)
            return false;
        if (rollno == null) {
            if (other.rollno != null)
                return false;
        } else if (!rollno.equals(other.rollno))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", dob="
                + dob + ", registerno=" + registerno + ", rollno=" + rollno + "]";
    }
     
}