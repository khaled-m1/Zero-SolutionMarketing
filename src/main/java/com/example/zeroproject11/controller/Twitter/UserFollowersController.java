package com.example.zeroproject11.controller.Twitter;

import com.example.zeroproject11.model.Twitter.AccountDetails;
import com.example.zeroproject11.model.Twitter.UserFollowers;
import com.example.zeroproject11.service.Twitter.AccountDetailsService;
import com.example.zeroproject11.service.Twitter.UserFollowersService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/followers")
@AllArgsConstructor
public class UserFollowersController {
    private final UserFollowersService userFollowersService;
    private final Logger log = LoggerFactory.getLogger(UserFollowersController.class);
    // get all FollowersAccount
    @GetMapping("/get-followers")
    public List<UserFollowers> getFollowers(){
        log.info("get All FollowersAccount");
        return userFollowersService.getFollowers();
    }


}
