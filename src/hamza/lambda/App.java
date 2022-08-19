package hamza.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {

        Student student1 = new Student("Tatiana", 25, Gender.FEMALE);
        Student student2 = new Student("Michael", 22, Gender.MALE);
        Student student3 = new Student("Mizgin", 23, Gender.FEMALE);
        Student student4 = new Student("Hamza", 35, Gender.MALE);
        Student student5 = new Student("Alena", 45, Gender.FEMALE);
        Student student6 = new Student("Marika", 55, Gender.FEMALE);

        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5, student6));

        System.out.println(studentList);

        // get older than 25


        get(studentList, student -> student.getAge() > 25);

        System.out.println("-----------------------------------------------");
        // get female students

        get(studentList, femalestudents -> femalestudents.getGender() == Gender.FEMALE);

        System.out.println("-----------------------------------------------");

        // get students who's first name start with m

        get(studentList, nameWithM -> nameWithM.getName().startsWith("M"));

        System.out.println("-----------------------------------------------");

        // use build in java function to get
        // ex output : Hamza is 35 years and male

        Function<Student, String> func = student -> student.getName() + " is " + student.getAge() + " years and " + student.getGender();
        System.out.println(func.apply(student1));
    }

    public static void get(List<Student> students, StudentFilter studentFilter) {

        for (Student student : students) {
            if (studentFilter.filter(student)) {
                System.out.println(student);
            }
        }

    }
}
