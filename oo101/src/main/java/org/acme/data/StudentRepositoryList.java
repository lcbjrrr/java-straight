package org.acme.data;

import org.acme.business.IStudentRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepositoryList implements IStudentRepository {

    private LinkedList<Student> students;
    private int studentCount;


    public StudentRepositoryList( ) {
        this.students = new LinkedList<Student>();
    }

    public void save(Student student) {
        this.students.add(student);
    }

    public Student findById(int position) {
        return this.students.get(position);
    }

    public List<Student> findAllByOrderByName() {
        return this.students.stream().sorted().collect(Collectors.toList());
    }
    public int count(){
        return students.size();
    }

    public Student findByName(String name){
        for (Student s : students) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }
}
