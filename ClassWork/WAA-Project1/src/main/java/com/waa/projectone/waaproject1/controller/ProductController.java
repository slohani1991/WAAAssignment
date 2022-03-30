package com.waa.projectone.waaproject1.controller;

import com.waa.projectone.waaproject1.domain.Product;
import com.waa.projectone.waaproject1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProduct(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductDetails(@PathVariable("id") int id){
        return  productService.getByID(id);
    }

}
