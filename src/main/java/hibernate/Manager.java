package hibernate;

import hibernate.model.Address;
import hibernate.model.Employee;
import hibernate.queries.Queries;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;
import java.util.Random;
import java.util.Set;


class Manager {

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            // FACTORY NAME HAS TO MATCHED THE ONE FROM PERSISTED.XML !!!
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();
            Session session = entityManager.unwrap(Session.class);

            //New transaction
            session.beginTransaction();

            // Create Employee
            Employee emp = createEmployee();

            // Save in First order Cache (not database yet)
            session.save(emp.getAddress());
            session.save(emp);

            Employee employee = session.get(Employee.class, emp.getId());
            if (employee == null) {
                System.out.println(emp.getId() + " not found! ");
            } else {
                System.out.println("Found " + employee);
            }

            System.out.println("Employee " + employee.getId() + " " + employee.getFirstName() + employee.getLastName());

            session.flush();
            session.refresh(employee);
            //
            changeFirstGuyToNowak(session);
            employee.setLastName("NowakPRE" + new Random().nextInt()); // No SQL needed

            //employee.getAddress().setStreet(null);

            //Commit transaction to database
            session.getTransaction().commit();

            employee.getAddress().setStreet(null);

            session.refresh(employee);

            getThemAll(session).stream().forEach(em -> System.out.println(em.getFirstName() + " " +em.getLastName()));

            System.out.println("Done");

            for (int i = 1; i < 10; i++) {
                session.save(Employee.copyEmployee(emp));
            }

            session.getTransaction().begin();
            Employee employee1 = session.get(Employee.class, 1);

            session.getTransaction().commit();

            session.clear();

            session.getTransaction().begin();

            employee1 = session.get(Employee.class, 1);
            Address add = employee1.getAddress();
            //System.out.println(add.getCity());

            session.getTransaction().commit();

            getAllEmployeeByPage(2, session).stream().forEach(em -> System.out.println(em.getFirstName()));

            session.getTransaction().begin();
            //session.delete(emp); //ERROR remove detached instance
            emp = createEmployee();
            emp.setId(1);

            // Save in First order Cache (not database yet)
            session.save(emp);

            session.close();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {

        }

    }

    private static Employee createEmployee() {
        Employee emp = new Employee();
        emp.setFirstName("Jan");
        emp.setLastName("Polak" + new Random().nextInt());
        emp.setSalary(100);
        emp.setPesel(new Random().nextInt());
        emp.setAddress(new Address("poznanska", "Poznan", "p", "p", "p"));
        return emp;
    }

    static List<Employee> getThemAll(Session session) {
        return session.createQuery("from Employee").getResultList();
    }

    static void changeFirstGuyToNowak(Session session) {

        List<Employee> employees = new Queries(session).getEmployeeByName("Polak");

        employees.get(0).setLastName("NowakPRE" + new Random().nextInt());

    }

    public static List<Employee> getAllEmployeeByPage(int pagenr, Session session) {
        //calculate total number
        Query queryTotal = session.createQuery
                ("Select count(e) from Employee e");
        long countResult = (long)queryTotal.getSingleResult();

        //create query
        Query query = session.createQuery("Select e FROM Employee e");
        //set pageSize
        int pageSize = 4;
        //calculate number of pages
        int pageNumber = (int) ((countResult / pageSize) + 1);

        if (pagenr > pageNumber) pagenr = pageNumber;
        query.setFirstResult((pagenr-1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

}