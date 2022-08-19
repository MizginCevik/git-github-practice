package lambdaexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentApp {

    public static void main(String[] args) {

        Student student1 = new Student("Tatiana",25,Gender.FEMALE);
        Student student2 = new Student("Michael",22,Gender.MALE);
        Student student3 = new Student("Mizgin",23,Gender.FEMALE);
        Student student4 = new Student("Hamza",35,Gender.MALE);
        Student student5 = new Student("Alena",45,Gender.FEMALE);
        Student student6 = new Student("Marika",55,Gender.FEMALE);

        List<Student> studentList = new ArrayList<>(Arrays.asList(student1,student2,student3,student4,student5,student6));

        System.out.println(studentList);


    }

    public void get(List<Student> students, StudentFilter studentFilter){

        for (Student student : students) {
            if (studentFilter.filter(student)){
                System.out.println(student);
            }
        }

    }
}
