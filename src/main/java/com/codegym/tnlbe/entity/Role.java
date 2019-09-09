package com.codegym.tnlbe.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private RoleName name;

    @ManyToMany(mappedBy = "roles")
    private Set<LandLord> landLords;

    public Set<LandLord> getLandLords() {
        return landLords;
    }

    public void setLandLords(Set<LandLord> landLords) {
        this.landLords = landLords;
    }

    public Role(RoleName name) {
        this.name = name;
    }

    public Role() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
