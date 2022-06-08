package com.example.zeroproject11.model;

import com.example.zeroproject11.model.Twitter.AccountDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;
    @NotEmpty(message = "your name must be not null")
    private String name;
    @NotEmpty(message = "type product must be not null")
    private String type;
    @NotNull(message = "price product must be a not null")
    private Integer price;

    // Class Cart
    @ManyToOne
    @JsonIgnore
    private Cart cart;
    // Class AccountDetails
    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AccountDetails accountDetails;
}
