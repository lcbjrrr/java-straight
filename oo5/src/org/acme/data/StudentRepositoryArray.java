package org.acme.data;

import org.acme.business.IStudentRepository;
import org.acme.business.Student;

import java.util.List;

public class StudentRepositoryArray implements IStudentRepository {

    private Student[] students;
    private int studentCount;

    public StudentRepositoryArray(int initialCapacity) {
        this.students = new Student[initialCapacity];
        this.studentCount = 0;
    }

    public int count() {
        return studentCount;
    }

    public void save(Student student) {
        this.students[studentCount] = student;
        studentCount++;
    }

    public Student findById(int position) {
        return this.students[position];
    }

    public List<Student> findAllByOrderByName(){
        //TODO
        return List.of(students);
    }

}


