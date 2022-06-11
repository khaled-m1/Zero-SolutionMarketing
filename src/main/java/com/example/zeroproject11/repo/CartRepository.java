package com.example.zeroproject11.repo;

import com.example.zeroproject11.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
