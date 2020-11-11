package streams.model;

public class Human {

    private String name;
    private int age;
    private String nationality;

    public Human(final String nameValue, final int ageValue) {
        name = nameValue;
        age = ageValue;
    }

    public Human(final String nameValue, final int ageValue, final String nationalityValue) {
        name = nameValue;
        age = ageValue;
        nationality = nationalityValue;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

}
