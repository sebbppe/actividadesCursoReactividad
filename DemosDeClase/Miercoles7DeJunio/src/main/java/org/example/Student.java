package org.example;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;

    private String course;

    private List<Integer> grades;

    private double average;

    private Integer numberOfGrades;

    public Student(String name, String course, List<Integer> grades) {
        this.name = name;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Integer getNumberOfGrades() {
        return numberOfGrades;
    }

    public void setNumberOfGrades(Integer numberOfGrades) {
        this.numberOfGrades = numberOfGrades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.average, average) == 0 && Objects.equals(name, student.name) && Objects.equals(course, student.course) && Objects.equals(grades, student.grades) && Objects.equals(numberOfGrades, student.numberOfGrades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course, grades, average, numberOfGrades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "\nname='" + name + '\'' +
                "\n, course='" + course + '\'' +
                "\n, grades=" + grades +
                "\n, average=" + average +
                "\n, numberOfGrades=" + numberOfGrades + "\n" +
                '}';
    }
}
