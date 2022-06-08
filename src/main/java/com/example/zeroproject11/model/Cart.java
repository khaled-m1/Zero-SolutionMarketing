package com.example.zeroproject11.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private Long userId;
    private Long productId;
    @NotNull(message = "Product price must be not empty :)")
    private Integer productPrice;



    // class user
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private Set<MyUser> myUser;
    // class product
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private Set<Product> product;
}
