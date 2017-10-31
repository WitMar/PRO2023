package hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "EMPLOYEE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"first_name","last_name"})})
public class Employee {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private int salary;

    @Column(name = "PESEL", nullable = false, unique = true)
    private int pesel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Address_ID", referencedColumnName = "id")
    Address address;

    @ManyToMany(mappedBy = "subworkers", cascade = CascadeType.ALL)
    private List<Employee> managers = new ArrayList<Employee>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Employee>  subworkers = new ArrayList<>();


    public Employee() {}

    public List<Employee> getManagers() {
        return managers;
    }

    public void setManagers(List<Employee> managers) {
        this.managers = managers;
    }

    public List<Employee> getSubworkers() {
        return subworkers;
    }

    public void setSubworkers(List<Employee> subworkers) {
        this.subworkers = subworkers;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String first_name ) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String last_name ) {
        this.lastName = last_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary( int salary ) {
        this.salary = salary;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}