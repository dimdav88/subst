package com.ue.bor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor  //lombok getters, setters, empty constructor.
@Entity //этот класс является сущностью. Use Hibernate. Its JPA classes annotation.
@Table(name = "users") //create table users. Its JPA classes annotation.
public class User implements UserDetails { //gets info about user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //generate id on server
    private Long id;

    @Pattern(regexp = "[A-Z][a-z]+", //Validation. Check only letters
            message = "Must start with a capital letter followed by one or more lowercase letters")
    @Column(name = "user_name", nullable = false)
    private String userName;

    @Pattern(regexp = "[A-Za-z\\d]{6,}",
            message = "Must be minimum 6 symbols long, using digits and latin letters")
    @Pattern(regexp = ".*\\d.*",
            message = "Must contain at least one digit")
    @Pattern(regexp = ".*[A-Z].*",
            message = "Must contain at least one uppercase letter")
    @Pattern(regexp = ".*[a-z].*",
            message = "Must contain at least one lowercase letter")
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
