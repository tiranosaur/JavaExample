package com.company.collection.model;

public class Student extends Person {
    private Integer course;
    private Double grade;

    public Student(String name, Integer age, Character sex, Integer course, Double grade) {
        super(name, age, sex);
        this.course = course;
        this.grade = grade;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("{name=%s, age=%s, sex=%s, course=%s, grade=%s}", getName(), getAge(), getSex(), getCourse(), getGrade());
    }
}

