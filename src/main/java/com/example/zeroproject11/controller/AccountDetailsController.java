package com.example.zeroproject11.controller;

import com.example.zeroproject11.dto.ApiResponce;
import com.example.zeroproject11.exsptions.InvalidExceptions;
import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.model.Twitter.AccountDetails;
import com.example.zeroproject11.service.AccountDetailsService;
import com.example.zeroproject11.service.MyUserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/account")
@AllArgsConstructor
public class AccountDetailsController {
    private final AccountDetailsService accountDetailsService;
    private final Logger log = LoggerFactory.getLogger(AccountDetailsController.class);
    // get all users
    @GetMapping("/get-account")
    public List<AccountDetails> getAccount(){
        log.info("get All Account");
        return accountDetailsService.getAccount();
    }


}
