package hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ADDRESSES")
public class Address {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "author_seq")
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    String street;

    @Column(nullable = false)
    String city;

    @Column(length = 5, nullable = false)
    String nr;

    @Column(length = 5)
    String housenr;

    @Column(length = 5, nullable = false)
    String postcode;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    Set<Employee> employee = new HashSet<>();

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getHousenr() {
        return housenr;
    }

    public void setHousenr(String housenr) {
        this.housenr = housenr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Address(String street, String city, String nr, String housenr, String postcode) {
        this.street = street;
        this.city = city;
        this.nr = nr;
        this.housenr = housenr;
        this.postcode = postcode;
    }
}
