package com.example.zeroproject11.controller;

import com.example.zeroproject11.dto.ApiResponce;
import com.example.zeroproject11.exsptions.InvalidExceptions;
import com.example.zeroproject11.model.Cart;
import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.service.CartService;
import com.example.zeroproject11.service.MyUserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;
    private final Logger log = LoggerFactory.getLogger(CartController.class);

    // get all cart
    @GetMapping("/get-cart")
    public List<Cart> getCart(){
        log.info("get All cart");
        return cartService.getCart();
    }
    // post cart
    @PostMapping("/add-cart")
    public ResponseEntity addCart(@RequestBody @Valid Cart cart){
        cartService.addCart(cart);
        log.info("add New cart");
        return ResponseEntity.status(201).body(new ApiResponce("Accept request :)",201));
    }
    // edit users
    @PutMapping("/edit-cart/{id}")
    public ResponseEntity editCart(@PathVariable Long id,
                                    @RequestBody Cart cart){
        cartService.editCart(id,cart);
        log.info("edit New cart");
        return ResponseEntity.status(201).body(new ApiResponce("Accept request :)",201));
    }
    // remove cart
    @DeleteMapping("/remove-cart/{index}")
    public ResponseEntity removeCart(@PathVariable Long index){
        log.info("delete request ");
        cartService.removeCart(index);
        return ResponseEntity.status(200).body(" cart removed :)");
    }



}
