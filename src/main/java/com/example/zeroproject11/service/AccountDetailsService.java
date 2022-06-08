package com.example.zeroproject11.service;

import com.example.zeroproject11.exsptions.InvalidExceptions;
import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.model.Twitter.AccountDetails;
import com.example.zeroproject11.repo.AccountDetailsRepository;
import com.example.zeroproject11.repo.MyUserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AccountDetailsService {
    private final AccountDetailsRepository accountDetailsRepository;
    private final Logger log = LoggerFactory.getLogger(AccountDetailsService.class);
    // get All users
    public List<AccountDetails> getAccount() {
        log.info("get All Account");
        return accountDetailsRepository.findAll();
    }

}
