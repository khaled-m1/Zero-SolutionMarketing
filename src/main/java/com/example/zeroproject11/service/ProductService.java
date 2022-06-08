package com.example.zeroproject11.service;

import com.example.zeroproject11.exsptions.InvalidExceptions;
import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.model.Product;
import com.example.zeroproject11.repo.MyUserRepository;
import com.example.zeroproject11.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final Logger log = LoggerFactory.getLogger(ProductService.class);
    // get All product
    public List<Product> getProduct() {
        log.info("get All product");
        return productRepository.findAll();
    }
    // post product
    public void addProduct(Product product) {
        productRepository.save(product);
        log.info("add New product");
    }
    // edit product
    public void editProduct(Long id, Product product) {
        Optional<Product> editProduct = productRepository.findById(id);
        if (editProduct.isEmpty()){
            throw new InvalidExceptions("product not find :(");
        }
        editProduct.get().setName(product.getName());
        editProduct.get().setType(product.getType());
        editProduct.get().setPrice(product.getPrice());
        productRepository.save(editProduct.get());
        log.info("edit product");
    }
    // remove product
    public void removeProduct(Long index) {
        productRepository.deleteById(index);
        log.info("removed product");
    }
}
