package com.example.zeroproject11.service;

import com.example.zeroproject11.exsptions.InvalidExceptions;
import com.example.zeroproject11.model.Cart;
import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.repo.CartRepository;
import com.example.zeroproject11.repo.MyUserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final Logger log = LoggerFactory.getLogger(CartService.class);
    // get All users
    public List<Cart> getCart() {
        log.info("get All cart");
        return cartRepository.findAll();
    }
    // post cart
    public void addCart(Cart cart) {
        cartRepository.save(cart);
        log.info("add New User");
    }
    // edit cart
    public void editCart(Long id, Cart cart) {
        Optional<Cart> editCart = cartRepository.findById(id);
        if (editCart.isEmpty()){
            throw new InvalidExceptions("cart not find :(");
        }
        editCart.get().setProductPrice(cart.getProductPrice());
        cartRepository.save(editCart.get());
        log.info("edit cart");
    }
    // remove users
    public void removeCart(Long index) {
        cartRepository.deleteById(index);
        log.info("removed Cart");
    }
}
