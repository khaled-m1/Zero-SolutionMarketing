package com.example.zeroproject11.controller;

import com.example.zeroproject11.dto.ApiResponce;
import com.example.zeroproject11.dto.MyUserInfoDTO;
import com.example.zeroproject11.model.MyUserInfo;
import com.example.zeroproject11.service.MyUserInfoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/user-info")
@AllArgsConstructor
public class MyUserInfoController {
    private final MyUserInfoService myUserInfoService;
    private final Logger log = LoggerFactory.getLogger(MyUserInfoController.class);
    // get all users
    @GetMapping("/get-user-info")
    public List<MyUserInfo> getUsersInfo(){
        log.info("get All Users Info");
        return myUserInfoService.getUsersInfo();
    }
    // post users
    @PostMapping("/add-user-info")
    public ResponseEntity addUsersInfo(@RequestBody MyUserInfoDTO info){
        myUserInfoService.addUsersInfo(info);
        log.info("add New User info");
        return ResponseEntity.status(201).body(new ApiResponce("Accept request :)",201));
    }
    // edit users
    @PutMapping("/edit-user-info/{id}")
    public ResponseEntity editUsersInfo(@PathVariable Long id,
                                        @RequestBody MyUserInfoDTO info){
        myUserInfoService.editUserInfo(id,info);
        log.info("edit New User");
        return ResponseEntity.status(201).body(new ApiResponce("Accept request :)",201));
    }
    // remove users
    @DeleteMapping("/remove-user/{index}")
    public ResponseEntity removeUserInfo(@PathVariable Long index){
        log.info("delete request ");
        myUserInfoService.removeUserInfo(index);
        return ResponseEntity.status(200).body("User removed :)");
    }
}
