package com.example.zeroproject11.service;
import com.example.zeroproject11.exsptions.InvalidExceptions;
import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.repo.MyUserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class MyUserService {
    private final MyUserRepository myUserRepository;
    private final Logger log = LoggerFactory.getLogger(MyUserService.class);
    // get All users
    public List<MyUser> getUsers() {
        log.info("get All Users");
        return myUserRepository.findAll();
    }
    // post users
//    public void addUsers(MyUser myUser) {
//        myUserRepository.save(myUser);
//        log.info("add New User");
//    }
    // edit Users
    public boolean editUser(Long id, MyUser myUser) {
        MyUser editUser = myUserRepository.findById(id).get();
        if (editUser == null){
            throw new InvalidExceptions("User not find :(");
        }
        editUser.setUsername(myUser.getUsername());
        editUser.setEmail(myUser.getEmail());
        myUserRepository.save(editUser);
        log.info("edit User");
        return true;
    }
    // remove users
    public void removeUser(Long index) {
        myUserRepository.deleteById(index);
        log.info("removed User");
    }
    // register
    public MyUser registerUser(MyUser myUser) {
        String hashedPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUserRepository.save(myUser);
        return myUser;
    }

}
