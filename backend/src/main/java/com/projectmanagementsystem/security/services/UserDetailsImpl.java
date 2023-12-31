package com.projectmanagementsystem.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectmanagementsystem.models.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private int id;

    private String username;

    private String mail;

    @JsonIgnore
    private String password;

    public UserDetailsImpl(Integer id, String username,
                           String mail, String password) {

        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;

    }

    public static UserDetailsImpl build(UserModel user) {

        return new UserDetailsImpl(user.getUserId(),
                user.getUsername(), user.getMail(),
                user.getPassword());
    }

    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public Collection<? extends GrantedAuthority>
    getAuthorities() {

        return null;
    }
}
