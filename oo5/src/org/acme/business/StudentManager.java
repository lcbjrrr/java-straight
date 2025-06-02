package org.acme.business;

public class StudentManager {
    IStudentRepository repository;
     public StudentManager(IStudentRepository repository) {
        this.repository=repository;
    }
    public void addStudent(Student student) {
        repository.save(student);
    }
    public Student getStudent(int position) {
        return repository.findById(position);
    }
    public double calculateAverage() {
        double totalGrade = 0;
        for (int i = 0; i < repository.count(); i++) {
            totalGrade = totalGrade+ this.getStudent(i).getGrade();
        }
        return totalGrade / repository.count();
    }

    public void printList() {
        for (int i = 0; i < repository.count(); i++) {
            System.out.println(this.getStudent(i).getName() + " : " + this.getStudent(i).getGrade());
        }
    }


}