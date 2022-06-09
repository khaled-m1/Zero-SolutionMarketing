package com.example.zeroproject11.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long userId;
    @NotEmpty(message = "username must be a not Empty :)")
    private String username;
    @Email(message = "Your email must be a real email :)")
    @NotEmpty(message = "Your email must be a not Empty :)")
    private String email;
    @NotEmpty(message = "Your password must be a not Empty :)")
    @Size(min = 6,message = "your password must be a more 6 char")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotEmpty(message = "Your email must be a real email :)")
    @Pattern(regexp = "(ADMIN|CUSTOMER)",message = "Select type user ADMIN or CUSTOMER")
    private String role;

    // User Details
    @OneToOne(mappedBy = "myUser",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private MyUserInfo myUserInfo;
    // Class cart
    @ManyToOne
    private Cart cart;

    // Securty
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.getRole()));
    }
    // band account
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // band account
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
