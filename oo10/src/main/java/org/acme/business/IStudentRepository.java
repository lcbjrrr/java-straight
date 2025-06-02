package org.acme.business;

import java.util.List;

public interface IStudentRepository {
    public void save(Student student);
    public Student findById(int position);
    public int count();
    public List<Student> findAllByOrderByName();
    public Student findByName(String name);
    // findAll()
}
