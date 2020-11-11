package streams;

import streams.model.Human;

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

    public static Map<String,Human> createMapOldJava(List<Human> collection) {
        Map<String,Human> people = new HashMap<>();
        for (Human element : collection) {
            people.put(element.getName(), element);
        }
        return people;
    }

    public static Map<String,Human> createMap(List<Human> collection) {
        Map<String, Human> result = collection.stream()
                .collect(Collectors.toMap(p -> p.getName(), Function.identity()));
        return result;
    }


    public static Human getOldestHumanOldJava(List<Human> people) {
        Human oldestHuman = new Human("", 0);
        for (Human person : people) {
            if (person.getAge() > oldestHuman.getAge()) {
                oldestHuman = person;
            }
        }
        return oldestHuman;
    }

    public static Human getOldestHuman(List<Human> people) {
        Human result = people.stream()
                .sorted(Comparator.comparing(Human::getAge).reversed())
                .findFirst().get();
        return result;
    }

    /**
     * HARD
     */


    public static Map<Boolean, List<Human>> partitionAdultsOldJava(List<Human> people) {
        Map<Boolean, List<Human>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Human person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map;
    }

    // use partitionBy
    public static Map<Boolean, List<Human>> partitionAdults(List<Human> people) {
        Map<Boolean, List<Human>> result = people.stream()
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