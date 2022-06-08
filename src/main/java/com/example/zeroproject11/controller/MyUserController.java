package com.example.zeroproject11.controller;

import com.example.zeroproject11.dto.ApiResponce;
import com.example.zeroproject11.exsptions.InvalidExceptions;
import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.service.MyUserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class MyUserController {
    private final MyUserService myUserService;
    private final Logger log = LoggerFactory.getLogger(MyUserController.class);
    // get all users
    @GetMapping("/get-user")
    public List<MyUser> getUsers(){
        log.info("get All Users");
        return myUserService.getUsers();
    }
    // post users
//    @PostMapping("/add-user")
//    public ResponseEntity addUsers(@RequestBody @Valid MyUser myUser){
//        myUserService.addUsers(myUser);
//        log.info("add New User");
//        return ResponseEntity.status(201).body(new ApiResponce("Accept request :)",201));
//    }
    // edit users
    @PutMapping("/edit-user/{id}")
    public ResponseEntity editUsers(@PathVariable Long id,
                                    @RequestBody MyUser myUser){
        boolean isEdit = myUserService.editUser(id,myUser);
        log.info("edit New User");
        if (!isEdit){
            log.info("edit request not valid");
            throw new InvalidExceptions(" Invalid request user edit :(");
        }
        return ResponseEntity.status(201).body(new ApiResponce("Accept request :)",201));
    }
    // remove users
    @DeleteMapping("/remove-user/{index}")
    public ResponseEntity removeUser(@PathVariable Long index){
        log.info("delete request ");
        myUserService.removeUser(index);
        return ResponseEntity.status(200).body("User removed :)");
    }
    // register
    @PostMapping("/register")
    public MyUser registerUser(@RequestBody @Valid MyUser myUser){
        myUserService.registerUser(myUser);
        return myUserService.registerUser(myUser);
    }
    @GetMapping("/logged")
    public ResponseEntity<String> logged(){
        return ResponseEntity.status(200).body("hello Users");
    }
    // Customer page
    @GetMapping("/customer")
    public ResponseEntity<ApiResponce> getCustomer(){
        return ResponseEntity.status(200).body(new ApiResponce("Hello User",200));
    }
    @GetMapping("/admin")
    public ResponseEntity<ApiResponce> getAdmin(){
        return ResponseEntity.status(200).body(new ApiResponce("Hello Admin",200));
    }
}
