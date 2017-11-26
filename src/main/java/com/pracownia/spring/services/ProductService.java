package com.pracownia.spring.services;

import com.pracownia.spring.entities.Product;
import java.util.Optional;

public interface ProductService {

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

    Boolean checkIfExist(Integer id);

}
