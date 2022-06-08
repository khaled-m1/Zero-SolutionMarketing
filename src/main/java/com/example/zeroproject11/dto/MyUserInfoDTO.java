package com.example.zeroproject11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class MyUserInfoDTO {
    private Long userId;
    private String cardId;
    private String cardName;
    private String cardDate;
    private String cardNumber;
}
