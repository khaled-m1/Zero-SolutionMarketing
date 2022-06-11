package com.example.zeroproject11.model.Twitter;

import com.example.zeroproject11.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class AccountDetails {
    @Id
    private String accountId;
    private String username;
    private String created_at;
    private String name;

    // Class Product
//    @OneToOne(cascade = CascadeType.ALL)
//    @MapsId
//    @JoinColumn(name = "productId")
//    @JsonIgnore
//    private Product product;
    // Class TweetDetail
    @OneToMany(mappedBy = "accountDetails",cascade = CascadeType.ALL)
    private Set<TweetDetail> tweetDetail;
    // Class UserFollowers
    @OneToMany(mappedBy = "accountDetails",cascade = CascadeType.ALL)
    private Set<UserFollowers> userFollowers;
}
