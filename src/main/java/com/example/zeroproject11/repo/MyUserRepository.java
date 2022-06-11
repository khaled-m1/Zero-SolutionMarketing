package com.example.zeroproject11.repo;

import com.example.zeroproject11.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser,Long> {
    MyUser findMyUserByUserId(Long id);
    Optional<MyUser> findMyUserByUsername(String username);
    List<MyUser> findByRole(String role);
}
