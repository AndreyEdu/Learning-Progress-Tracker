package tracker;

public class Student {

    //private String firstName;
    //private String lastName;
    //private String email;
    private static int countStudents;

    public Student() {
        countStudents++;
    }

    public static int getCountStudents() {
        return countStudents;
    }
}
