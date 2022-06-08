package com.example.zeroproject11.service;

import com.example.zeroproject11.dto.MyUserInfoDTO;
import com.example.zeroproject11.exsptions.InvalidExceptions;
import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.model.MyUserInfo;
import com.example.zeroproject11.repo.MyUserInfoRepository;
import com.example.zeroproject11.repo.MyUserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class MyUserInfoService {
    private final MyUserInfoRepository myUserInfoRepository;
    private final MyUserRepository myUserRepository;
    private final Logger log = LoggerFactory.getLogger(MyUserInfoService.class);
    // get All users
    public List<MyUserInfo> getUsersInfo() {
        log.info("get All Users");
        return myUserInfoRepository.findAll();
    }
    // post users
    public void addUsersInfo(MyUserInfoDTO info) {
        MyUser myUser = myUserRepository.findById(info.getUserId()).get();
        MyUserInfo myUserInfo = new MyUserInfo(null,info.getCardId(),info.getCardName(),info.getCardDate(),info.getCardNumber(),myUser);
        myUserInfoRepository.save(myUserInfo);
        log.info("add New User");
    }
    // edit Users
    public void editUserInfo(Long id, MyUserInfoDTO info) {
        Optional<MyUserInfo> editUser = myUserInfoRepository.findById(id);
        if (editUser.isEmpty()){
            throw new InvalidExceptions("User not find :(");
        }
        editUser.get().setCardId(info.getCardId());
        editUser.get().setCardName(info.getCardName());
        editUser.get().setCardDate(info.getCardDate());
        editUser.get().setCardNumber(info.getCardNumber());
        myUserInfoRepository.save(editUser.get());
        log.info("edit User");
    }
    // remove users
    public void removeUserInfo(Long index) {
        myUserInfoRepository.deleteById(index);
        log.info("removed User");
    }
}
