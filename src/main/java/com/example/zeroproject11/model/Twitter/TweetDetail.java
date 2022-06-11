package com.example.zeroproject11.model.Twitter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class TweetDetail {
    @Id
    private String tweetId;
    private String text;
    private String created_at;
    private String author_id;

    // Class AccountDetails
    @ManyToOne
    @JsonIgnore
    private AccountDetails accountDetails;
}
