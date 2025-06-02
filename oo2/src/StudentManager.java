
public class StudentManager {
    private Student[] students; // The fixed-size array to store students
    private int studentCount;   // Tracks the actual number of students added

    // Constructor: Initializes the array with a specified initial capacity
    public StudentManager(int initialCapacity) {
        this.students = new Student[initialCapacity];
        this.studentCount = 0;
    }



    // Adds a Student object to the registry
    public void addStudent(Student student) {
        this.students[studentCount] = student;
        studentCount++; // Increment the count of actual students
    }

    // Gets a Student object at a specific position
    public Student getStudent(int position) {
        return this.students[position];
    }

    // Sorts students by grade (using bubble sort) and calculates the average grade
    public double calculateAverage() {
        double totalGrade = 0;
        for (int i = 0; i < studentCount; i++) {
            totalGrade = totalGrade+ this.students[i].getGrade(); // Sum grades while iterating
        }
        return totalGrade / studentCount;
    }

    // Prints the list of students (name: grade)
    public void printList() {
        // Iterate only up to studentCount
        for (int i = 0; i < studentCount; i++) {
            System.out.println(this.students[i].getName() + " : " + this.students[i].getGrade());
        }
    }

    // --- Main method for demonstrating the functionality ---
    public static void main(String[] args) {
        // Create an instance with an initial capacity (e.g., 3 to see resizing happen early)
        StudentManager school = new StudentManager(10);

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