package com.waa.projectone.waaproject1.repo;

import com.waa.projectone.waaproject1.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepoImpl implements ProductRepo {

    private List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product save(Product product) {
        productList.add(product);
        return  product;
    }

    @Override
    public Product getByID(int Id) {
        return productList.stream().filter(x-> x.getId()==Id).findFirst().get();
    }

    @Override
    public Product update(Product product) {
       return null;
    }

    @Override
    public void delete(int id) {

    }


}
