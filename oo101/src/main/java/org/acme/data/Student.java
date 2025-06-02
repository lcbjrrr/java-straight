package org.acme.data;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student implements Comparable<Student> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
    private int id;
    private String name;
    private double grade;
    public Student(){}
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

     public String getName() {
        return name;
    }

     public void setName(String name) {
        this.name = name;
    }

     public double getGrade() {
        return grade;
    }

     public void setGrade(double grade) {
        this.grade = grade;
    }

    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

}