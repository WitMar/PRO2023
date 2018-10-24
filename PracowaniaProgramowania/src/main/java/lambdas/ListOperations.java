package lambdas;

import model.Address;
import model.Employee;
import org.joda.time.DateTime;
import pl.edu.amu.pracprog.ModelObjectsCreator;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOperations {

    public static void main(String[] args) throws IOException {

        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(objectsCreator.getEmp());
        employeeList.add(objectsCreator.getEmp2());
        employeeList.addAll(addEmp());

        //For loop through list
        IntStream.range(0,employeeList.size())
                .forEach(iter -> System.out.println(employeeList.get(iter).getFirstName()));

        System.out.println("**************************");

        //Foreach type loop through the list
        employeeList.forEach(emploee -> System.out.println(emploee.getFirstName()));

        System.out.println("**************************");

        //Loop filtering only those people which name start with A
        employeeList.stream()
                .filter(emploee -> emploee.getFirstName().startsWith("A"))
                .forEach(element -> System.out.println(element.getFirstName()));

        System.out.println("**************************");

        //Loop, map object to strings -> names and filtering only those people which name start with B
        employeeList.stream()
                .map(employee -> employee.getFirstName())
                .filter(name -> name.startsWith("B"))
                .forEach(element -> System.out.println(element));

        System.out.println("**************************");

        //Loop, map object to address city names and return distinct
        employeeList.stream()
                .map(employee -> employee.getAddress().getCity())
                .distinct()
                .forEach(element -> System.out.println(element));

        System.out.println("**************************");

        //Loop writing names sorted
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .forEach(element -> System.out.println(element.getFirstName()));

        System.out.println("**************************");

        //Loop get person with the first alphabetical name
        System.out.println(employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .findFirst().get().getFirstName());

        System.out.println("**************************");

        //Create List of names
        List<String> list = employeeList.stream()
                .map(employee -> employee.getFirstName())
                .collect(Collectors.toList());

        System.out.println("**************************");

        //Create Map name -> employee
        Map<String, Employee> map = employeeList.stream()
                .collect(Collectors.toMap(employee -> employee.getFirstName(), employee -> employee, (a, b) -> a));

        System.out.println(map.entrySet());
        
    }

    private static List<Employee> addEmp() {

        List<Employee> employees = new ArrayList<>();

        Employee emp = new Employee();
        emp.setFirstName("Adam");
        emp.setLastName("Adamski" + new Random().nextInt());
        emp.setSalary(10);
        emp.setPesel(Math.abs(new Random().nextInt()));
        emp.setBirth(DateTime.now());

        Employee emp2 = new Employee();
        emp2.setFirstName("Bob");
        emp2.setLastName("Dylan" + new Random().nextInt());
        emp2.setSalary(1000);
        emp2.setPesel(Math.abs(new Random().nextInt()));
        emp2.setBirth(DateTime.now().minusMonths(100));

        //add address
        Address address = new Address();
        address.setCity("Berlin");
        address.setStreet("BerlinerStrasse");
        address.setNr("1");
        address.setPostcode("99090");

        emp.setAddress(address);
        emp2.setAddress(address);

        employees.add(emp);
        employees.add(emp2);

        return employees;
    }
}
