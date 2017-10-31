package hibernate;

import hibernate.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

            Employee emp = new Employee();
            emp.setFirstName("Jan");
            emp.setLastName("Polak" + new Random().nextInt());
            emp.setSalary(100);
            emp.setPesel(new Random().nextInt());

            entityManager.persist(emp);

            Employee employee = entityManager.find(Employee.class, emp.getId());

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

    static void changeFirstGuyToNowak(EntityManager entityManager) {

        Query query = entityManager.createQuery("SELECT k FROM Employee k");
        List<Employee> employees = query.getResultList();

        employees.get(2).setLastName("Nowak" + new Random().nextInt());

    }

}