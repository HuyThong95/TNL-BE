package com.codegym.tnlbe.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "LandLord")
public class LandLord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String fullName;

    @NotBlank
    @NaturalId
    @Size(min = 3, max = 50)
    private String name;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 100)
    private String passWord;

    @NotBlank
    @NaturalId
    @Size(min = 10, max = 11)
    private String phoneNumber;
    @OneToMany(targetEntity = Apartment.class)
    private List<Apartment> apartments;

    @ManyToMany
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public LandLord() {
    }

    public LandLord(@NotBlank @Size(min = 3, max = 50) String fullName, @NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 6, max = 100) String passWord, @NotBlank @Size(min = 10, max = 11) String phoneNumber) {
        this.fullName = fullName;
        this.name = name;
        this.email = email;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
