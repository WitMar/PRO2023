package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("select count(*) from Product p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
