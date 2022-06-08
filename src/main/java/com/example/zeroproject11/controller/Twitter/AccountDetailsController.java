package com.example.zeroproject11.controller.Twitter;

import com.example.zeroproject11.model.Twitter.AccountDetails;
import com.example.zeroproject11.service.Twitter.AccountDetailsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/account")
@AllArgsConstructor
public class AccountDetailsController {
    private final AccountDetailsService accountDetailsService;
    private final Logger log = LoggerFactory.getLogger(AccountDetailsController.class);
    // get all Account
    @GetMapping("/get-account")
    public List<AccountDetails> getAccount(){
        log.info("get All Account");
        return accountDetailsService.getAccount();
    }


}
