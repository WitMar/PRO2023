package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Product;
import com.pracownia.spring.entities.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SellerRepository extends CrudRepository<Seller, Integer> {

    List<Seller> findByName(String name);

    Integer countProductsById(Integer id);

    List<Product> getProductsById(int id);

    @Query("select sum(p.price) from Seller s join s.productsOb p where s.id = ?1")
    Long countSumOfProductCosts(Integer id);

    @Query("select p from Seller s join s.productsOb p where s.id = ?1")
    List<Product> getProductsByIdv2(Integer id);

    @Query("select p from Seller s join s.products ps, Product p where p.productId = ps.id and s.id = ?1")
    List<Product> getProductsByIdv3(Integer id);
}
