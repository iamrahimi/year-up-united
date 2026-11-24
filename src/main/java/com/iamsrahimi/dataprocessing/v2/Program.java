package com.iamsrahimi.dataprocessing.v2;

import com.iamsrahimi.dataprocessing.v1.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Ali", "Rahimi", 25));
        people.add(new Person("Sara", "Khan", 29));
        people.add(new Person("John", "Smith", 32));
        people.add(new Person("Maria", "Garcia", 27));
        people.add(new Person("David", "Brown", 41));
        people.add(new Person("Amina", "Hassan", 23));
        people.add(new Person("Michael", "Johnson", 35));
        people.add(new Person("Fatima", "Noor", 30));
        people.add(new Person("James", "Wilson", 22));
        people.add(new Person("Sayed", "Rahimi", 28));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a first or last name to search: ");
        String search = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

        List<Person> searchResults = people.stream()
                .filter(person ->
                        person.getFirstName().toLowerCase(Locale.ROOT).contains(search)
                                || person.getLastName().toLowerCase(Locale.ROOT).contains(search))
                .collect(Collectors.toList());

        OptionalDouble averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average();

        Optional<Person> oldestPerson = people.stream()
                .max(Comparator.comparingInt(Person::getAge));

        Optional<Person> youngestPerson = people.stream()
                .min(Comparator.comparingInt(Person::getAge));

        System.out.println("Average age: " + averageAge.orElse(0.0));

        oldestPerson.ifPresent(person ->
                System.out.println("Oldest person: " + person.getFirstName()
                        + " " + person.getLastName() + ", age " + person.getAge()));

        youngestPerson.ifPresent(person ->
                System.out.println("Youngest person: " + person.getFirstName()
                        + " " + person.getLastName() + ", age " + person.getAge()));

        System.out.println("Search results:");
        searchResults.forEach(person ->
                System.out.println(person.getFirstName() + " "
                        + person.getLastName() + ", age " + person.getAge()));

        scanner.close();
    }
}
