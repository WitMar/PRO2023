package fluentAPI.interfaces;

import fluentAPI.model.Person;

import java.util.List;
import java.util.function.Function;

public interface IPerson {

    IPerson addFriend(Person friend);
    IPerson sayHelloToFriends();
    IPerson processFriends(Function<List<Person>, List<Person>> processor);
    IPerson chooseBestFriend(Function<List<Person>, Person> picker);
    void print();

}
