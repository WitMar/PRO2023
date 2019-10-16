import com.sun.xml.internal.bind.v2.TODO;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.impl.block.factory.MultimapFunctions;
import org.eclipse.collections.impl.collector.Collectors2;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import streams.model.Person;

import java.util.List;
import java.util.Map;

public class MainEclipseCollections {

    public static void main(String[] args) {
        FastListMultimap<String, String> citiesToPeople = FastListMultimap.newMultimap();

        citiesToPeople.put("Poznan", "Nowak");
        citiesToPeople.put("Poznan", "Kowalski");

        citiesToPeople.get("Poznan").forEach(name -> System.out.println(name));
    }

    public static MutableListMultimap<Boolean, Person> partitionAdults(List<Person> collection) {
        // ToDo
        return null;
    }
}
