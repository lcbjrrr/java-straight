public class Person {
    String first;
    String last;

    Person(String f, String l) {
        this.first=f;
        this.last=l;
    }
    String getFullName() {
        return this.first+" "+this.last;
    }
    public static void main(String[] args) {
        Person john = new Person("John","Doe");
        System.out.println(john.getFullName());
    }

    public static void mainx(String[] args) {
        String first = "John";
        String last = "Doe";
        String fn = fullName(first,last);
        System.out.println(fn);
    }

    static String fullName(String f, String l) {
        return f+" "+l;
    }
}
