package com.waa.projectone.waaproject1.service;

import com.waa.projectone.waaproject1.domain.Product;
import com.waa.projectone.waaproject1.repo.ProductRepo;
import com.waa.projectone.waaproject1.repo.ProductRepoImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getByID(int id) {
        return productRepo.getByID(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }
}
