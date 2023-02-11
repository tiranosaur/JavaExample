package com.company.collection.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private List<Student> studentList;

    public Faculty(String name) {
        this.name = name;
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public List<Student> getStudentOnFaculty() {
        return studentList;
    }
}
