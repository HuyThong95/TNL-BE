package com.codegym.tnlbe.entity;

import javax.persistence.*;

@Entity
@Table(name = "Apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String houseKind;
    @Column
    private String roomKind;
    @Column
    private String address;
    @Column
    private String roomNumber;
    @Column
    private String bathRoomNumber;
    @Column
    private String description;
    @Column
    private String prizePerNight;

    @ManyToOne
    @JoinColumn(name = "LandLord_id")
    private LandLord landLord;

    public LandLord getLandLord() {
        return landLord;
    }

    public void setLandLord(LandLord landLord) {
        this.landLord = landLord;
    }

    public Apartment() {
    }

    public Apartment(String name, String houseKind, String roomKind, String address, String roomNumber, String bathRoomNumber, String description, String prizePerNight) {
        this.name = name;
        this.houseKind = houseKind;
        this.roomKind = roomKind;
        this.address = address;
        this.roomNumber = roomNumber;
        this.bathRoomNumber = bathRoomNumber;
        this.description = description;
        this.prizePerNight = prizePerNight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseKind() {
        return houseKind;
    }

    public void setHouseKind(String houseKind) {
        this.houseKind = houseKind;
    }

    public String getRoomKind() {
        return roomKind;
    }

    public void setRoomKind(String roomKind) {
        this.roomKind = roomKind;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBathRoomNumber() {
        return bathRoomNumber;
    }

    public void setBathRoomNumber(String bathRoomNumber) {
        this.bathRoomNumber = bathRoomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrizePerNight() {
        return prizePerNight;
    }

    public void setPrizePerNight(String prizePerNight) {
        this.prizePerNight = prizePerNight;
    }
}
