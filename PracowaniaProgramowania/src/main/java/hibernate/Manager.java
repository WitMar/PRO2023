package hibernate;

import hibernate.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class Manager {

    public static void main(String[] args) {
        System.out.println("Hibernate one to one (Annotation)");

        try {
            // Create the SessionFactory from hibernate.cfg.xml
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Employee employee = new Employee();

            employee.setFirstName("Jan");
            employee.setLastName("Polak");
            employee.setSalary(100);

            session.save(employee);

            employee.setPesel(1010);
            session.save(employee);

            session.getTransaction().commit();

            System.out.println("Done");

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
}