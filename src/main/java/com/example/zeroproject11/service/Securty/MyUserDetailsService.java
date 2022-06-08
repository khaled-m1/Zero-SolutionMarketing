package com.example.zeroproject11.service.Securty;

import com.example.zeroproject11.model.MyUser;
import com.example.zeroproject11.repo.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final MyUserRepository myUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = myUserRepository.findMyUserByUsername(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return user.get();
    }

}
