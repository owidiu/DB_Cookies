package com.example.homework7.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductModel createProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public ProductModel getProduct(Integer id) {
        return productRepository.findById(id).get();
    }

    public ProductModel updateProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public Iterable<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

}


