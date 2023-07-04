package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainWithFunctionalInterfaces {

    public static Supplier<List<Student>> studentsSupplier = () -> {
        Student santiago = new Student("Santiago", "Calculo", List.of(5,8,9,5,7,8,9,5));
        Student pablo = new Student("pablo", "fisica", List.of(6,5,9,10,7,6));
        Student valentina = new Student("valentina", "Calculo", List.of(8,9,7,9,10,7));
        Student leonardo = new Student("leonardo", "redes", List.of(5,8,9,7,6,9,10,10,10,7));
        Student juan = new Student("juan", "fisica", List.of(9,8,7,9,8,9,8,10,5));
        Student melissa = new Student("melissa", "redes", List.of(10,9,8,7,10,5,5,8,10));
        return new ArrayList<>(List.of(santiago, pablo, valentina, leonardo, juan, melissa));
    };

    public static Consumer<Student> studentPrinter = (student) -> System.out.println(student);

    public static Function<List<Student>, Set<Student>> studentsAutoComplete = (List<Student> students) -> {
        return students.stream().map(student -> {
            Student newStudent = new Student(student.getName(), student.getCourse(), student.getGrades());
            int numberOfGrades = student.getGrades().size();
            double average = student.getGrades().stream().reduce(0, Integer::sum).doubleValue() / numberOfGrades;
            newStudent.setAverage(average);
            newStudent.setNumberOfGrades(numberOfGrades);
            return newStudent;
        }).collect(Collectors.toSet());
    };

    public static Predicate<Student> gradeValidator = student -> student.getAverage() > 7.5 ;

}
