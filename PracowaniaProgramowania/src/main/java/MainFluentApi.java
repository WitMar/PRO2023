import fluentAPI.Person;
import fluentAPI.PersonBuilderBuilder;
import fluentAPI.interfaces.Title;

import java.util.List;
import java.util.function.Function;

public class MainFluentApi {

    public static void main(String[] args) {

        //Package-private constructor is not accessible here, we must use the builder:
        //Person p = new Person("a",Title.PROF);

        PersonBuilderBuilder personBuilder = new PersonBuilderBuilder();
        Person person = personBuilder.withName("Marcin Witkowski")
                .withTitle(Title.DR)
                .build();

        Person student = personBuilder.withName("John Doe")
                .withTitle(Title.STUDENT)
                .build();

        person.addFriend(student).sayHelloToFriends();

        person.processFriends(friends -> {
            friends.clear();
            return friends;
        }).sayHelloToFriends();

        Function<List<Person>, Person> chooseMyFirstFriendEver = friends -> friends.get(0);
        person.addFriend(student)
                .chooseBestFriend(chooseMyFirstFriendEver)
                .print();
    }
}