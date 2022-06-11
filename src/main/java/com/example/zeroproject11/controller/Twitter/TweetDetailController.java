package com.example.zeroproject11.controller.Twitter;

import com.example.zeroproject11.model.Twitter.TweetDetail;
import com.example.zeroproject11.service.Twitter.TweetDetailService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tweet")
@AllArgsConstructor
public class TweetDetailController {
    private final TweetDetailService tweetDetailService;
    private final Logger log = LoggerFactory.getLogger(TweetDetailController.class);
    // get all tweet Detail
    @GetMapping("/get-tweet")
    public List<TweetDetail> getTweet(){
        log.info("get All Tweets");
        return tweetDetailService.getTweet();
    }
}
