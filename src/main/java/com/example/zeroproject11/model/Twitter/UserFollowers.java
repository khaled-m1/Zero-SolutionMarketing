package com.example.zeroproject11.model.Twitter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class UserFollowers {
    @Id
    private Long user_id;
    private LocalDate creation_date;
    private String username;
    private String name;

    private String location;
    private String profile_pic_url;
    private String description;
    private Integer number_of_tweets;
    private boolean bot;

    // Class AccountDetails
    @ManyToOne
    @JsonIgnore
    private AccountDetails accountDetails;
}
