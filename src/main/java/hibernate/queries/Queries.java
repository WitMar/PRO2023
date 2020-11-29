package hibernate.queries;

import hibernate.model.Employee;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Queries {

    Session session;

    public Queries(Session session) {
        this.session = session;
    }

    public List<Employee> getEmployeeByName(String name) {
        return session.createQuery(
                "SELECT c FROM Employee c WHERE c.lastName LIKE :name", Employee.class)
                .setParameter("name", "%" + name + "%").list();
    }
}
