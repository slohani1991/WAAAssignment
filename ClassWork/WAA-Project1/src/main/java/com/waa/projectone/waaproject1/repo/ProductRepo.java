package com.waa.projectone.waaproject1.repo;

import com.waa.projectone.waaproject1.domain.Product;

import java.util.List;

public interface ProductRepo {

    public List<Product> findAll();

    public Product save(Product product);

    public Product getByID(int Id);

    public Product update(Product product);

    public void delete(int id);

}
