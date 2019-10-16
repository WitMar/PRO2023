package streams;

import streams.model.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

// Code from https://github.com/vfarcic/java-8-exercises

public class Task {

    public static List<String> toUpperCaseOldJava(List<String> collection) {
        List<String> newCollection = new ArrayList<>();
        for (String element : collection) {
            newCollection.add(element.toUpperCase());
        }
        return newCollection;
    }

    public static List<String> toUpperCase(List<String> collection) {
        // ToDo
        return null;
    }

    public static Person getOldestPersonOldJava(List<Person> people) {
        Person oldestPerson = new Person("", 0);
        for (Person person : people) {
            if (person.getAge() > oldestPerson.getAge()) {
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }

    public static Person getOldestPerson(List<Person> people) {
        // ToDo
        return null;
    }

    public static Map<Boolean, List<Person>> partitionAdultsOldJava(List<Person> people) {
        Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Person person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map;
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        // ToDo
        return null;
    }

    public static List<String> transformOldJava(List<String> collection) {
        List<String> newCollection = new ArrayList<>();
        for (String element : collection) {
            if (element.length() < 4) {
                newCollection.add(element);
            }
        }
        return newCollection;
    }

    public static List<String> transform(List<String> collection) {
        // ToDo
        return null;
    }

    public static Map<String,Person> createMapOldJava(List<Person> collection) {
        Map<String,Person> people = new HashMap<>();
        for (Person element : collection) {
            people.put(element.getName(), element);
        }
        return people;
    }

    public static Map<String,Person> createMap(List<Person> collection) {
        // ToDo
        return null;
    }


    public static List<String> transformListOldJava(List<List<String>> collection) {
        List<String> newCollection = new ArrayList<>();
        for (List<String> subCollection : collection) {
            for (String value : subCollection) {
                newCollection.add(value);
            }
        }
        return newCollection;
    }

    public static List<String> transformList(List<List<String>> collection) {
        // ToDo
        return null;
    }


}