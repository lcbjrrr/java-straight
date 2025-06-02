public class Student {
    // Private instance variables (fields) to store student data
    private String name; // Corresponds to __nome
    private double grade; // Corresponds to __nota (using double for potential decimal grades)

    // Constructor: Initializes the Student object when it's created
    public Student(String name, double grade) {
        this.name = name; // 'this.name' refers to the instance variable, 'name' refers to the parameter
        this.grade = grade;
    }

    // Getter for 'name' (equivalent to Python's @property for 'nome')
    public String getName() {
        return name;
    }

    // Setter for 'name' (equivalent to Python's @nome.setter)
    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'grade' (equivalent to Python's @property for 'nota')
    public double getGrade() {
        return grade;
    }

    // Setter for 'grade' (equivalent to Python's @nota.setter)
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // --- Optional: main method for testing the Student class ---
    public static void main(String[] args) {
        // Create a new Student object
        Student student1 = new Student("Alice", 85.5);

        // Access properties using getters
        System.out.println("Student Name: " + student1.getName());    // Output: Student Name: Alice
        System.out.println("Student Grade: " + student1.getGrade());  // Output: Student Grade: 85.5

        // Modify properties using setters
        student1.setName("Alice Smith");
        student1.setGrade(90.0);

        // Verify changes
        System.out.println("\nUpdated Student Name: " + student1.getName()); // Output: Updated Student Name: Alice Smith
        System.out.println("Updated Student Grade: " + student1.getGrade());// Output: Updated Student Grade: 90.0
    }
}