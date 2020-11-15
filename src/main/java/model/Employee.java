package model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;

    private String firstName;

    private String lastName;

    private int salary;

    private int pesel;

    Address address;

    private List<Employee> managers = new ArrayList<>();

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