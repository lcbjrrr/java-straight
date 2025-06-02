package org.acme.gui;

import java.util.List;

import org.acme.business.StudentManager;
import org.acme.business.exception.StudentAlreadyEnrolledExpection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.acme.data.Student;

@Component
public class GUI {

    private final StudentManager studentManager;

    @Autowired
    public GUI(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GUI gui = context.getBean(GUI.class);
        gui.run();
    }
    public void run() {

        System.out.println("Adding students...");

        try {
            studentManager.addStudent(new Student("Luiz", 5.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try {
            studentManager.addStudent(new Student("Ze", 7.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            studentManager.addStudent(new Student("Mane", 3.0)); // This might trigger a resize if initial capacity was 3
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            studentManager.addStudent(new Student("Maria", 2.0)); // This will trigger a resize if initial capacity was 3
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            studentManager.addStudent(new Student("Luiz", 1.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}

        System.out.println("\nInitial List (after adding, might have been resized):");
        printList(studentManager.getOrderedStudents());

        System.out.println("-------");
        double averageGrade = studentManager.calculateAverage();

        System.out.println(averageGrade);
    }

    static public void printList(List<Student> students) {
        for (Student s : students) {
            System.out.println(s.getName() + " : " + s.getGrade());
        }
    }
}