package org.acme.gui;

import org.acme.business.Student;
import org.acme.business.StudentManager;
import org.acme.data.StudentRepositoryArray;

public class GUI {
    public static void main(String[] args) {
        StudentManager school = new StudentManager(new StudentRepositoryArray(10));

        System.out.println("Adding students...");
        school.addStudent(new Student("Luiz", 5.0));
        school.addStudent(new Student("Ze", 7.0));
        school.addStudent(new Student("Mane", 3.0)); // This might trigger a resize if initial capacity was 3
        school.addStudent(new Student("Maria", 2.0)); // This will trigger a resize if initial capacity was 3
        school.addStudent(new Student("Joao", 1.0));

        System.out.println("\nInitial List (after adding, might have been resized):");
        school.printList();

        System.out.println("-------");

        // Sort students and calculate the average grade
        double averageGrade = school.calculateAverage();


        school.printList();
        System.out.println(averageGrade);
    }
}