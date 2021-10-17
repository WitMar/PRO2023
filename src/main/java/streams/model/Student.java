package streams.model;

public class Student {

    private String name;
    private Long year;
    private Long id;

    public Student(String name, Long year, Long id) {
        this.name = name;
        this.year = year;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
