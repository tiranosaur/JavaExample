package com.company.collection.stream.flatMap;

import com.company.collection.model.Faculty;
import com.company.collection.model.Person;
import com.company.collection.model.Student;

import java.util.ArrayList;
import java.util.List;

public class FlatMap2 {
    public static void main(String[] args) {
        Student student1 = new Student("First Student", 25, 'm', 3, 3.3);
        Student student2 = new Student("Second Student", 12, 'f', 1, 1.1);
        Student student3 = new Student("Third Student", 44, 'm', 5, 7.6);
        Student student4 = new Student("Forth Student", 38, 'm', 4, 6.2);
        Student student5 = new Student("Fifth Student", 64, 'f', 3, 4.2);

        Faculty economic = new Faculty("Economic");
        economic.addStudent(student1);
        economic.addStudent(student2);
        economic.addStudent(student5);

        Faculty phisics = new Faculty("Phisics");
        phisics.addStudent(student4);
        phisics.addStudent(student3);
        phisics.addStudent(student5);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(economic);
        facultyList.add(phisics);

        facultyList.stream()
                .flatMap(faculty -> faculty.getStudentOnFaculty().stream())
                .map(Person::getName)
                .forEach(System.out::println);
    }
}

