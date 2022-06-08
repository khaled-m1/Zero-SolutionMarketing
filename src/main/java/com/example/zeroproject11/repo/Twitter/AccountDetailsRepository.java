package com.example.zeroproject11.repo.Twitter;

import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.model.Twitter.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails,String> {
}
