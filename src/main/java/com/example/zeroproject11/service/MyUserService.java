package com.example.zeroproject11.service;
import com.example.zeroproject11.exsptions.InvalidExceptions;
import com.example.zeroproject11.model.Cart;
import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.model.Product;
import com.example.zeroproject11.repo.CartRepository;
import com.example.zeroproject11.repo.MyUserInfoRepository;
import com.example.zeroproject11.repo.MyUserRepository;
import com.example.zeroproject11.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@AllArgsConstructor
public class MyUserService {
    private final MyUserRepository myUserRepository;
    private final MyUserInfoRepository myUserInfoRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    private final Logger log = LoggerFactory.getLogger(MyUserService.class);
    // get All users
    public List<MyUser> getUsers() {
        log.info("get All Users");
        return myUserRepository.findAll();
    }
    // post users
//    public void addUsers(MyUser myUser) {
//        myUserRepository.save(myUser);
//        log.info("add New User");
//    }
    // edit Users
    public boolean editUser(Long id, MyUser myUser) {
        MyUser editUser = myUserRepository.findById(id).get();
        if (editUser == null){
            throw new InvalidExceptions("User not find :(");
        }
        editUser.setUsername(myUser.getUsername());
        editUser.setEmail(myUser.getEmail());
        editUser.setBalance(myUser.getBalance());
        myUserRepository.save(editUser);
        log.info("edit User");
        return true;
    }
    // remove users
    public void removeUser(Long index) {
        myUserRepository.deleteById(index);
        log.info("removed User");
    }
    // register
    public MyUser registerUser(MyUser myUser) {
        String hashedPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUserRepository.save(myUser);
        return myUser;
    }
    // pay product
    public Integer payProduct(Long userId, Long productId) {
        MyUser myUser = myUserRepository.findById(userId).get();
        Product product = productRepository.findById(productId).get();
        if (product == null || myUser == null){
            return -1;
        }
        if (myUser.getBalance()<product.getPrice()){
            return 0;
        }
        Integer oldBalance=myUser.getBalance();
        myUser.setBalance(oldBalance-product.getPrice());
        myUserRepository.save(myUser);
        return 1;
    }
    // payProduct with cart
    public Integer payProductCart(Long userId, Long productId, Long cartId) {
        MyUser myUser = myUserRepository.findById(userId).get();
        Product product = productRepository.findById(productId).get();
        Cart cart = cartRepository.findById(cartId).get();
        if (product == null || myUser == null || cart == null){
            return -1;
        }
        if (myUser.getBalance()<product.getPrice()){
            return 0;
        }
        Integer oldBalance=myUser.getBalance();
        myUser.setBalance(oldBalance-product.getPrice());
        myUserRepository.save(myUser);
        return 1;
    }
    public List<MyUser> getUserByRole(String role) {
        return myUserRepository.findByRole(role);
    }



}
