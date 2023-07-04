package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Student> students=MainWithFunctionalInterfaces.studentsSupplier.get();
        List<Student> students1=Main.autoComplete(students);
        List<Student> studentsPassed=Main.filterStudentsThatPassed(students1);
        var numberOfStudents=Main.filterNumberStudentsThatPassed(students1);
        System.out.println("-----------------------------------");
        students1.stream().forEach(MainWithFunctionalInterfaces.studentPrinter);
        System.out.println("-----------------------------------");
        studentsPassed.stream().forEach(MainWithFunctionalInterfaces.studentPrinter);
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
        return students.stream().filter(MainWithFunctionalInterfaces.gradeValidator).collect(Collectors.toList());
   }
    private static Long filterNumberStudentsThatPassed(List<Student> students){
        return students.stream().filter(MainWithFunctionalInterfaces.gradeValidator).count();
    }
}