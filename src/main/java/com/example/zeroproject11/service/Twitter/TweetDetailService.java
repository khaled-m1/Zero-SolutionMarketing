package com.example.zeroproject11.service.Twitter;

import com.example.zeroproject11.model.Twitter.TweetDetail;
import com.example.zeroproject11.model.Twitter.UserFollowers;
import com.example.zeroproject11.repo.Twitter.TweetDetailRepository;
import com.example.zeroproject11.repo.Twitter.UserFollowersRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TweetDetailService {
    private final TweetDetailRepository tweetDetailRepository;
    private final Logger log = LoggerFactory.getLogger(TweetDetailService.class);
    // get All tweet Detail
    public List<TweetDetail> getTweet() {
        log.info("get All tweet Detail");
        return tweetDetailRepository.findAll();
    }

}
