package fluentAPI;

import fluentAPI.interfaces.IPersonBuilder;
import fluentAPI.interfaces.Title;

import java.util.stream.IntStream;

public class PersonBuilderBuilder implements IPersonBuilder {

    Title title;
    String name;

    public Person build() {
        Person person = new Person(this.name, this.title);
        return person;
    }

    @Override
    public IPersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IPersonBuilder withTitle(Title title) {
        this.title = title;
        return this;
    }
}
