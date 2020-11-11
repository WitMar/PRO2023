import streams.Task;
import streams.model.Human;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaskTest {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
        List<String> expected = Arrays.asList("MY", "NAME", "IS", "JOHN", "DOE");
        assertThat(Task.toUpperCase(collection), is(expected));
    }

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Human sara = new Human("Sara", 4);
        Human viktor = new Human("Viktor", 40);
        Human eva = new Human("Eva", 42);
        List<Human> collection = Arrays.asList(sara, eva, viktor);
        assertThat(Task.getOldestHuman(collection), is(eva));
    }

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Human sara = new Human("Sara", 4);
        Human viktor = new Human("Viktor", 40);
        Human eva = new Human("Eva", 42);
        List<Human> collection = Arrays.asList(sara, eva, viktor);
        Map<Boolean, List<Human>> result = Task.partitionAdults(collection);
        assertThat(result.get(true),is(Arrays.asList(eva, viktor)));
        assertThat(result.get(false),is(Arrays.asList(sara)));
    }

    @Test
    public void transformKeepStringsShorterThant4Characters() {
        List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
        List<String> expected = Arrays.asList("My", "is", "Doe");
        assertThat(Task.transform(collection), is(expected));
    }

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = Arrays.asList(Arrays.asList("Viktor", "Farcic"), Arrays.asList("John", "Doe", "Third"));
        List<String> expected = Arrays.asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertThat(Task.transformList(collection), is(expected));
    }

    @Test
    public void mapNameToPerson() {
        Human sara = new Human("Sara", 4);
        Human viktor = new Human("Viktor", 40);
        Human eva = new Human("Eva", 42);
        Map<String, Human> map = new HashMap<>();
        map.put(sara.getName(),sara);
        map.put(viktor.getName(),viktor);
        map.put(eva.getName(),eva);
        List<Human> collection = Arrays.asList(sara, eva, viktor);
        Map<String, Human> result = Task.createMap(collection);
        assertThat(result,is(map));
    }

}