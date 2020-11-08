import fluentAPI.Person;
import fluentAPI.PersonBuilder;
import fluentAPI.interfaces.Title;

import java.util.List;
import java.util.function.Function;

public class MainFluentApi {

    public static void main(String[] args) {

        //Package-private constructor is not accessible here, we must use the builder:
        //Person p = new Person("a",Title.PROF);

        PersonBuilder builder = new PersonBuilder();
        Person Marcin = builder.withName("Marcin").withTitle(Title.DR).build();

        builder = new PersonBuilder();
        Person Joe = builder.withName("Joe Biden").withTitle(Title.PRESIDENT).build();

        builder = new PersonBuilder();
        Person Donald = builder.withName("Donald Trump").withTitle(Title.PRESIDENT).build();

        Marcin.addFriend(Joe).addFriend(Donald);
        Marcin.sayHelloToFriends();

        Marcin.processFriends(friends -> {
            friends.clear();
            return friends;
        }).sayHelloToFriends();

        Marcin.addFriend(Joe).addFriend(Donald);
        Marcin.processFriendsInPlace(friends -> {
            friends.clear();
        }).sayHelloToFriends();

        Function<List<Person>, Person> chooseMyFirstFriendEver = friends -> friends.get(0);
        Marcin.addFriend(Joe).addFriend(Donald)
                .chooseBestFriend(chooseMyFirstFriendEver)
                .print();
    }
}