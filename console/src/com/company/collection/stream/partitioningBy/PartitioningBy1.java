package com.company.collection.stream.partitioningBy;


import com.company.collection.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PartitioningBy1 {
    public static void main(String[] args) {
        Student student1 = new Student("First Student", 25, 'm', 3, 3.3);
        Student student2 = new Student("Second Student", 12, 'f', 1, 1.1);
        Student student3 = new Student("Third Student", 44, 'm', 5, 7.6);
        Student student4 = new Student("Forth Student", 38, 'm', 4, 6.2);
        Student student5 = new Student("Fifth Student", 64, 'f', 3, 4.2);

        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5));

// ---- Student toString replaced
        studentList.stream()
                .collect(Collectors.partitioningBy(x -> x.getAge() > 30))
                .entrySet()
                .stream()
                .forEach(System.out::println);
    }

    private static Student renameStudent(Student student, String name) {
        student.setName(name);
        return student;
    }
}
