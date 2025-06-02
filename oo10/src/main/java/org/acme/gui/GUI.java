package org.acme.gui;

import org.acme.business.Student;
import org.acme.business.StudentManager;
import org.acme.business.exception.StudentAlreadyEnrolledExpection;
import org.acme.data.StudentRepositoryArray;
import org.acme.data.StudentRepositoryDB;
import org.acme.data.StudentRepositoryList;
import org.acme.integration.FBIWantedIntegration;

import java.util.List;

public class GUI {
    public static void main(String[] args) {
        StudentManager school = new StudentManager(new StudentRepositoryDB(),new FBIWantedIntegration());

        System.out.println("Adding students...");
        try {
            school.addStudent(new Student("Luiz", 5.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try {
            school.addStudent(new Student("Ze", 7.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            school.addStudent(new Student("Mane", 3.0)); // This might trigger a resize if initial capacity was 3
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            school.addStudent(new Student("Maria", 2.0)); // This will trigger a resize if initial capacity was 3
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            school.addStudent(new Student("Luiz", 1.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}

        System.out.println("\nInitial List (after adding, might have been resized):");
        printList(school.getOrderedStudents());
        System.out.println("------- "+school.calculateAverage());
        System.out.println("\n Enroll Students From Partner...");
        try {
            school.enrollStudentsFromPartner();
            System.out.println("------- "+school.calculateAverage());
        } catch (StudentAlreadyEnrolledExpection e) {
            throw new RuntimeException(e);
        }
    }
    static public void printList(List<Student> students) {
        for (Student s : students) {
            System.out.println(s.getName() + " : " + s.getGrade());
        }
    }
}