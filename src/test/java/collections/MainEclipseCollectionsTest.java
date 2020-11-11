package collections;

import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.junit.Test;
import streams.model.Human;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainEclipseCollectionsTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Human sara = new Human("Sara", 4);
        Human viktor = new Human("Viktor", 40);
        Human eva = new Human("Eva", 42);
        List<Human> collection = Arrays.asList(sara, eva, viktor);
        MutableListMultimap<Boolean, Human> result = MainEclipseCollections.partitionAdults(collection);
        assertThat(result.get(true),is(Arrays.asList(eva, viktor)));
        assertThat(result.get(false),is(Arrays.asList(sara)));
    }

}