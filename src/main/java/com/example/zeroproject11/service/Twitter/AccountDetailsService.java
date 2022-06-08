package com.example.zeroproject11.service.Twitter;

import com.example.zeroproject11.model.Twitter.AccountDetails;
import com.example.zeroproject11.repo.Twitter.AccountDetailsRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AccountDetailsService {
    private final AccountDetailsRepository accountDetailsRepository;
    private final Logger log = LoggerFactory.getLogger(AccountDetailsService.class);
    // get All Account
    public List<AccountDetails> getAccount() {
        log.info("get All Account");
        return accountDetailsRepository.findAll();
    }

}
