package ru.mirea.practice.s21k0627.task2;

import java.util.Comparator;

public abstract class Test {
    public static void main(String[] args) {
        SortingStudentsByGPA sorting = new SortingStudentsByGPA();

        Student[] students = new Student[]{
                new Student("Petya", "Petrov", "computer engineering", 2, "CE-21", 50),
                new Student("Vasya", "Ivanov", "physics", 1, "P-22", 35),
                new Student("Nastya", "Sidorova", "math", 4, "M-19", 48),
                new Student("Slava", "Andreev", "pedagogy", 2, "PED-21", 32),
                new Student("Olga", "Petrova", "computer engineering", 2, "CE-21", 42)
        };

        sorting.setArray(students);

        Comparator<Student> scoreComparator = Comparator.comparingInt(Student::getScore);

        sorting.quickSort(scoreComparator, 0, students.length - 1);
        sorting.getArray();

        System.out.println();

        try {
            System.out.println("Finding student with lastname 'Ivanov'...");
            sorting.findStudent("Ivanov");
        } catch (EmptyStringException | StudentNotFoundException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Finding student with lastname 'Kvashnina'...");
            sorting.findStudent("Kvashnina");
        } catch (EmptyStringException | StudentNotFoundException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Finding student with lastname ' '...");
            sorting.findStudent(null);
        } catch (EmptyStringException | StudentNotFoundException e) {
            System.out.println(e);
        }
    }
}
