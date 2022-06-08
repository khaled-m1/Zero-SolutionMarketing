package com.example.zeroproject11.model.Twitter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class TweetDetail {
    @Id
    private String tweet_id;
    private String creation_date;
    private String text;
    private String name;
    private String user_id; // FK
    private String language;
    private boolean is_verified;
    private Integer favorite_count;
    private Integer retweet_count;
    private Integer reply_count;
    private Integer quote_count;
    private boolean retweet;

    // Class AccountDetails
    @ManyToOne
    @JsonIgnore
    private AccountDetails accountDetails;
}
