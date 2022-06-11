package com.example.zeroproject11.repo.Twitter;

import com.example.zeroproject11.model.Twitter.UserFollowers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserFollowersRepository extends JpaRepository<UserFollowers,String> {
}
