package com.example.zeroproject11.repo;

import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.model.MyUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserInfoRepository extends JpaRepository<MyUserInfo,Long> {
}
