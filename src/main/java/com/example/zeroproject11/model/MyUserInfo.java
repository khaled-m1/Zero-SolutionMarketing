package com.example.zeroproject11.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class MyUserInfo {
    @Id
    private Long user_detailsId;
    @NotEmpty(message = "Your Card Id must be a not Empty :)")
    private String cardId;
    @NotEmpty(message = "Your Card Name must be a not Empty  :)")
    private String cardName;
    @NotEmpty(message = "Your Card Date must be a not Empty  :)")
    private String cardDate;
    @NotEmpty(message = "Your Card Number must be a not Empty  :)")
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "userId")
    @JsonIgnore
    private MyUser myUser;
}
