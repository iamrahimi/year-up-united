package com.iamsrahimi.dataprocessing.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        System.out.println("Search: enter first name/ last name to search: ");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine().trim();

        List<Person> searchResult = new ArrayList<>();

        float avarage = 0;
        int oldestPerson = 0;
        int youngestPerson = 0;

        for (Person person : people) {

            if(oldestPerson == 0 && youngestPerson == 0 ) {
                youngestPerson = person.getAge();
                oldestPerson = person.getAge();
            }


            avarage += person.getAge();
            if(person.getFirstName().toLowerCase().contains(search.toLowerCase()) || person.getLastName().toLowerCase().contains(search.toLowerCase())) {
                searchResult.add(person);
            }

            if(person.getAge() > oldestPerson) {
                oldestPerson = person.getAge();
            }

            if(person.getAge() < youngestPerson) {
                youngestPerson = person.getAge();
            }
        }

        System.out.println("Average age:" + (avarage / people.size()));
        System.out.println("Oldest person:" + oldestPerson);
        System.out.println("Youngest person:" + youngestPerson);

        System.out.println("Search results: ");
        for (Person person : searchResult) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }
    }
}
