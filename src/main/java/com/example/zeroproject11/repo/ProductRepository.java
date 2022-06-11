package com.example.zeroproject11.repo;

import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByPrice(Integer price);
}
