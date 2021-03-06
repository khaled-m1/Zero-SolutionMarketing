package com.example.zeroproject11.config;

import com.example.zeroproject11.service.Securty.MyUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurtyConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService myUserDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/user/register/**").permitAll()
                .antMatchers("/api/v1/user/admin").hasAuthority("ADMIN")
                .antMatchers("/api/v1/user/logged/**").hasAnyAuthority("ADMIN","CUSTOMER")
                .anyRequest().authenticated()
                .and().httpBasic();

//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest().permitAll()
//                .and().httpBasic();
    }
}
