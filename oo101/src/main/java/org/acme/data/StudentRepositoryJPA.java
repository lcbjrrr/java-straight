package org.acme.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositoryJPA extends JpaRepository<Student, Integer>{ // and IStudentRepository{
        // Spring Data JPA automatically provides:
        // save(Student student)
        // findById(Integer id)
        // findAll()
        // count()

        // Custom query methods (Spring Data JPA will implement these for you)
        Student findByName(String name); // Equivalent to your findByName
        List<Student> findAllByOrderByName();
}

