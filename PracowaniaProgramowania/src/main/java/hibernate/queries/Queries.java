package hibernate.queries;

import hibernate.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Queries {

    EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Employee> getEmployeeByName(String name) {
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT c FROM Employee c WHERE c.lastName LIKE :name", Employee.class);
        return query.setParameter("name", name).getResultList();
    }

    public List<Employee> getAllEmployeeByPage(int pagenr) {
        //calculate total number
        Query queryTotal = entityManager.createQuery
                ("Select count(f) from Employee f");
        long countResult = (long)queryTotal.getSingleResult();

        //create query
        Query query = entityManager.createQuery("Select e FROM Employee e");
        //set pageSize
        int pageSize = 10;
        //calculate number of pages
        int pageNumber = (int) ((countResult / pageSize) + 1);

        if (pagenr > pageNumber) pagenr = pageNumber;
        query.setFirstResult((pagenr-1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }
}
