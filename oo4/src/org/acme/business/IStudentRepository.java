package org.acme.business;

public interface IStudentRepository {
    public void save(Student student);
    public Student findById(int position);
    public int count();
    // findAll()
    //Student findByName(String name);
    //List<Student> findAllByOrderByNameAsc(); // Equivalent to your getOrderedStudents
}
