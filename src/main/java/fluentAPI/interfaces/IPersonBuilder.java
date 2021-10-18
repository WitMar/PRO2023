package fluentAPI.interfaces;

import fluentAPI.model.Person;

public interface IPersonBuilder {

    IPersonBuilder withName(String name);
    IPersonBuilder withTitle(Title title);
    Person build();

}

