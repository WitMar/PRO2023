package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Product;
import com.pracownia.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ProductService productService;

    @RequestMapping("")
    String index() {
        return "index";
    }


    @RequestMapping(value = "generateModel", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {
        Product p1 = new Product(UUID.randomUUID().toString(),"Jajko", new BigDecimal(2.50));
        Product p2 = new Product(UUID.randomUUID().toString(),"Masło", new BigDecimal(3.50));
        Product p3 = new Product(UUID.randomUUID().toString(),"Mąka", new BigDecimal(1.50));

        productService.saveProduct(p1);
        productService.saveProduct(p2);
        productService.saveProduct(p3);

        return "Model Generated";
    }

}
