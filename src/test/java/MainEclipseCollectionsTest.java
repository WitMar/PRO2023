import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.junit.Test;
import streams.Task;
import streams.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MainEclipseCollectionsTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = Arrays.asList(sara, eva, viktor);
        MutableListMultimap<Boolean, Person> result = MainEclipseCollections.partitionAdults(collection);
        assertThat(result.get(true),is(Arrays.asList(eva, viktor)));
        assertThat(result.get(false),is(Arrays.asList(sara)));
    }

}