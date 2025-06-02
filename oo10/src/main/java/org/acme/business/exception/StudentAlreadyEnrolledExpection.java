package org.acme.business.exception;

import org.acme.business.Student;

public class StudentAlreadyEnrolledExpection extends Exception {
    private Student student;
    public StudentAlreadyEnrolledExpection(Student student) {
        this.student = student;
    }
}

