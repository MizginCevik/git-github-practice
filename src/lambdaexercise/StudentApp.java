package lambdaexercise;

import java.util.*;
import java.util.function.Function;

public class StudentApp {

    public static void main(String[] args) {

        Student student1 = new Student("Tatiana", 25, Gender.FEMALE);
        Student student2 = new Student("Michael", 22, Gender.MALE);
        Student student3 = new Student("Mizgin", 23, Gender.FEMALE);
        Student student4 = new Student("Hamza", 35, Gender.MALE);
        Student student5 = new Student("Alena", 45, Gender.FEMALE);
        Student student6 = new Student("Marika", 55, Gender.FEMALE);

        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5, student6));


        studentList.forEach(System.out::println);

        System.out.println("*************************************************************");

        //System.out.println(studentList);

        //get all students elder than 25
        StudentFilter studentFilter1 = student -> student.getAge() > 25;
        get(studentList, studentFilter1);

        //get all student are Female


        //get all students first name starts with M


        //use one in build java functional interface and get all student info in following format
        // sample output : Hamza is 35 years and Male

        Function<Student, String> function = student -> student.getFullName() + " is " + student.getAge() + " years and " + student.getGender();
//        System.out.println(function.apply(student6));
//        System.out.println(function.apply(student1));

//        for (Student student : studentList) {
//            System.out.println(function.apply(student));
//        }

        print(studentList, function);

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getAge()>o2.getAge()) ? 1 :  (o1.getAge()<o2.getAge()) ? -1 :0 ;
            }
        });

        System.out.println(studentList);
    }

    public static void get(List<Student> students, StudentFilter studentFilter) {

        for (Student student : students) {
            if (studentFilter.filter(student)) {
                System.out.println(student);
            }
        }
    }

    public static void print(List<Student> students, Function<Student, String> function) {
        for (Student student : students) {
            //String output = function.apply(student);
            System.out.println(function.apply(student));
        }
    }
}
