package hibernate;

import hibernate.model.Address;
import hibernate.model.Employee;
import hibernate.queries.Queries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Manager {

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            //add 1
            Employee emp = new Employee();
            emp.setFirstName("Jan");
            emp.setLastName("Polak" + new Random().nextInt());
            emp.setSalary(100);
            emp.setPesel(new Random().nextInt());

            //add 2
            Employee emp2 = new Employee();
            emp2.setFirstName("Roman");
            emp2.setLastName("Polak" + new Random().nextInt());
            emp2.setSalary(100);
            emp2.setPesel(new Random().nextInt());

            //save 2
            entityManager.persist(emp2);

            //add address
            Address address = new Address();
            address.setCity("poznan");
            address.setStreet("poznanska");
            address.setNr("1");
            address.setPostcode("99090");

            emp.setAddress(address);
            emp2.setAddress(address);
            emp.getSubworkers().add(emp2);

            entityManager.persist(address);
            entityManager.persist(emp);

            Employee employee = entityManager.find(Employee.class, emp.getId());
            if (employee == null) {
                System.out.println(emp.getId() + " not found! ");
            } else {
                System.out.println("Found " + employee);
            }

            System.out.println("Employee " + employee.getId() + " " + employee.getFirstName() + employee.getLastName());

            changeFirstGuyToNowak(entityManager);

            entityManager.getTransaction().commit();

            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

    // read a page of empleyees and change first one to Nowak
    static void changeFirstGuyToNowak(EntityManager entityManager) {

        Query query = entityManager.createQuery("SELECT k FROM Employee k");
        List<Employee> employees = new Queries(entityManager).getAllEmployeeByPage(1);

        employees.get(0).setLastName("NowakPRE" + new Random().nextInt());

    }

}