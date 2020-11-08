package streams;

import streams.model.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


// Code from https://github.com/vfarcic/java-8-exercises

public class Task {

    /**
     * EASY
     */

    public static List<String> toUpperCaseOldJava(List<String> collection) {
        List<String> newCollection = new ArrayList<>();
        for (String element : collection) {
            newCollection.add(element.toUpperCase());
        }
        return newCollection;
    }

    public static List<String> toUpperCase(List<String> collection) {
        List<String> result = collection.stream()
                .map(o -> o.toUpperCase())
                .collect(Collectors.toList());
        return result;
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
        List<String> result = collection.stream()
                .filter(o -> o.length() < 4)
                .collect(Collectors.toList());
        return result;
    }

    /**
     * MEDIUM
     */

    public static Map<String,Person> createMapOldJava(List<Person> collection) {
        Map<String,Person> people = new HashMap<>();
        for (Person element : collection) {
            people.put(element.getName(), element);
        }
        return people;
    }

    public static Map<String,Person> createMap(List<Person> collection) {
        Map<String, Person> result = collection.stream()
                .collect(Collectors.toMap(p -> p.getName(), Function.identity()));
        return result;
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
        Person result = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .findFirst().get();
        return result;
    }

    /**
     * HARD
     */


    public static Map<Boolean, List<Person>> partitionAdultsOldJava(List<Person> people) {
        Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Person person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map;
    }

    // use partitionBy
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        Map<Boolean, List<Person>> result = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 18));
        return result;
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

    //use flatMap
    public static List<String> transformList(List<List<String>> collection) {
        List<String> result = collection.stream()
                .flatMap(a -> a.stream())
                .collect(Collectors.toList());
        return result;
    }
}