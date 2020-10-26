package second.junit;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FrodoTest {

    Creature frodo = new Creature("Frodo", 33L, Race.HOBBIT);
    Creature sauron = new Creature("Sauron", 10000L, Race.WIZARD);
    List<Creature> fellowshipOfTheRing = new ArrayList<Creature>();
    Creature boromir = new Creature("Boromir", 37L, Race.MAN);
    Creature sam = new Creature("Sam", 38L, Race.HOBBIT);
    Creature merry = new Creature("Merry", 36L, Race.HOBBIT);
    Creature pippin = new Creature("Pippin", 28L, Race.HOBBIT);
    Creature legolas = new Creature("Legolas", 2500L, Race.ELF);
    Creature aragorn = new Creature("Aragorn", 87L, Race.MAN);
    Creature gimli = new Creature("Gimli", 139L, Race.DWARF);
    Creature gandalf = new Creature("Gandalf", 3000L, Race.WIZARD);

    @Before
    public void prepareData() {
        fellowshipOfTheRing.add(frodo);
        fellowshipOfTheRing.add(sam);
        fellowshipOfTheRing.add(merry);
        fellowshipOfTheRing.add(pippin);
        fellowshipOfTheRing.add(legolas);
        fellowshipOfTheRing.add(aragorn);
        fellowshipOfTheRing.add(boromir);
        fellowshipOfTheRing.add(gimli);
        fellowshipOfTheRing.add(gandalf);
    }

    @Test
    public void assertJtestexample() {

        // basic assertions
        assertThat(frodo.getName()).isEqualTo("Frodo");
        assertThat(frodo).isNotEqualTo(sauron);

        // chaining string specific assertions
        assertThat(frodo.getName()).startsWith("Fro")
                .endsWith("do")
                .isEqualToIgnoringCase("frodo");

        // collection specific assertions (there are plenty more)
        assertThat(fellowshipOfTheRing).hasSize(9)
                .contains(frodo, sam)
                .doesNotContain(sauron);

        // as() is used to describe the test and will be shown before the error message
        assertThat(frodo.getAge()).isEqualTo(33);
    }

    @Test
    public void test() {

        // using the 'extracting' feature to check fellowshipOfTheRing character's names
        assertThat(fellowshipOfTheRing).extracting(Creature::getName)
                .doesNotContain("Sauron", "Elrond");

        // extracting multiple values at once grouped in tuples
        assertThat(fellowshipOfTheRing).extracting("name", "age", "race")
                .contains(tuple("Boromir", 37L, Race.MAN),
                        tuple("Sam", 38L, Race.HOBBIT),
                        tuple("Legolas", 2500L, Race.ELF));

        // filtering a collection before asserting
        assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o"))
                .containsOnly(aragorn, frodo, legolas, boromir);

        // combining filtering and extraction (yes we can)
        assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o"))
                .containsOnly(aragorn, frodo, legolas, boromir)
                .extracting(character -> character.getRace())
                .contains(Race.HOBBIT, Race.ELF, Race.MAN);
    }

}

class Creature {
    String name;
    Long age;
    Race race;

    public Creature(String name, Long age, Race race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}

enum Race {
    HOBBIT,
    ORK,
    WIZARD,
    ELF,
    MAN,
    DWARF
}