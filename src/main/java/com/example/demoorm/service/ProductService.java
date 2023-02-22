package com.example.demoorm.service;

import com.example.demoorm.model.Product;
import com.example.demoorm.reponsity.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements Crud<Product>{
    @Autowired
    private ProductReponsitory productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(findById(id));
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
