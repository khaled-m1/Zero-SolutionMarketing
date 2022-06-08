package com.example.zeroproject11.repo;

import com.example.zeroproject11.model.Cart;
import com.example.zeroproject11.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
