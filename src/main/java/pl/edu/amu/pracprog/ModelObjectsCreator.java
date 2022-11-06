package pl.edu.amu.pracprog;

import model.Address;
import model.Employee;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Helper class which provides methods to create instances of hibernate.model classes
 */
public class ModelObjectsCreator {

    Employee emp;
    Employee emp2;
    Address address;

    List<Employee> employees;

    public Employee getEmp() {
        return emp;
    }

    public Employee getEmp2() {
        return emp2;
    }

    public Address getAddress() {
        return address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void init(){
        emp = new Employee();
        emp.setFirstName("Jan");
        emp.setLastName("Polak" + new Random().nextInt());
        emp.setSalary(100);
        emp.setPesel(Math.abs(new Random().nextInt()));
        emp.setBirthDate(new DateTime());

        emp2 = new Employee();
        emp2.setFirstName("Roman");
        emp2.setLastName("Polak" + new Random().nextInt());
        emp2.setSalary(100);
        emp2.setPesel(Math.abs(new Random().nextInt()));
        emp2.setBirthDate(new DateTime().plusDays(10));

        //add address
        Address address = new Address();
        address.setCity("Poznan");
        address.setStreet("poznanska");
        address.setNr("1");
        address.setPostcode("99090");

        emp.setAddress(address);
        emp2.setAddress(address);
        emp.getSubworkers().add(emp2);

        //This will give us infinite recursion
        emp2.getManagers().add(emp);

        employees = new ArrayList<Employee>();
        employees.add(emp);
        employees.add(emp2);

    }

    public ModelObjectsCreator(){
        init();
    }


}
