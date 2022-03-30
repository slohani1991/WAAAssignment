package com.waa.projectone.waaproject1.service;

import com.waa.projectone.waaproject1.domain.Product;
import com.waa.projectone.waaproject1.repo.ProductRepo;

import java.util.List;

public interface ProductService{

    public List<Product> getAllProducts();

    public Product addProduct(Product product);

    public Product getByID(int id);

    public Product updateProduct(Product product);

    public void deleteProduct(int id);

}
