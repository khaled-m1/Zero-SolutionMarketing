package com.example.zeroproject11.service.Twitter;

import com.example.zeroproject11.model.Twitter.UserFollowers;
import com.example.zeroproject11.repo.Twitter.UserFollowersRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserFollowersService {
    private final UserFollowersRepository userFollowersRepository;
    private final Logger log = LoggerFactory.getLogger(UserFollowersService.class);
    // get All FollowersAccount
    public List<UserFollowers> getFollowers() {
        log.info("get All FollowersAccount");
        return userFollowersRepository.findAll();
    }

}
