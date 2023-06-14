package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student santiago = new Student("Santiago", "Calculo", List.of(5,8,9,5,7,8,9,5));
        Student pablo = new Student("pablo", "fisica", List.of(6,5,9,10,7,6));
        Student valentina = new Student("valentina", "Calculo", List.of(8,9,7,9,10,7));
        Student leonardo = new Student("leonardo", "redes", List.of(5,8,9,7,6,9,10,10,10,7));
        Student juan = new Student("juan", "fisica", List.of(9,8,7,9,8,9,8,10,5));
        Student melissa = new Student("melissa", "redes", List.of(10,9,8,7,10,5,5,8,10));

        List<Student> students=new ArrayList<>(List.of(santiago,pablo,valentina,leonardo,juan,melissa));
        List<Student> students1=Main.autoComplete(students);
        List<Student> studentsPassed=Main.filterStudentsThatPassed(students1);
        var numberOfStudents=Main.filterNumberStudentsThatPassed(students1);
        System.out.println("-----------------------------------");
        students1.stream().forEach(System.out::println);
        System.out.println("-----------------------------------");
        studentsPassed.stream().forEach(System.out::println);
        System.out.println("-----------------------------------");
        System.out.println(numberOfStudents);
   }

   public static List<Student> autoComplete(List<Student> students){
        return students.stream().map(student -> {
            int numberOfGrades=student.getGrades().size();
            double average=student.getGrades().stream().reduce(0, Integer::sum)/numberOfGrades;
            student.setAverage(average);
            student.setNumberOfGrades(numberOfGrades);
            return student;
        }).collect(Collectors.toList());
   }
   private static List<Student> filterStudentsThatPassed(List<Student> students){
        return students.stream().filter(student -> student.getAverage()>7.5).collect(Collectors.toList());
   }
    private static Long filterNumberStudentsThatPassed(List<Student> students){
        return students.stream().filter(student -> student.getAverage()>7.5).count();
    }
}