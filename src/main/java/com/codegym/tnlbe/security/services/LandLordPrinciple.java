package com.codegym.tnlbe.security.services;

import com.codegym.tnlbe.entity.LandLord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LandLordPrinciple implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String fullName;
    private String name;
    private String phoneNumber;

    @JsonIgnore
    private String passWord;

    private String email;

    private Collection<? extends GrantedAuthority> authorities;

    public LandLordPrinciple(Long id, String fullName, String name, String phoneNumber, String passWord, String email, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.fullName = fullName;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
        this.email = email;
        this.authorities = authorities;
    }

    public static LandLordPrinciple build(LandLord landLord){
        List<GrantedAuthority> authorities = landLord.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        return new LandLordPrinciple(
          landLord.getId(),
          landLord.getEmail(),
          landLord.getFullName(),
          landLord.getName(),
          landLord.getPassWord(),
          landLord.getPhoneNumber(),
          authorities
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        LandLordPrinciple landLord = (LandLordPrinciple) obj;
        return Objects.equals(id, landLord.id);
    }
}
