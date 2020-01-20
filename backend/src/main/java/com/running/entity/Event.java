package com.running.entity;

import javax.persistence.*;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="street")
    private String street;
    @Column(name="state")
    private String state;
    @Column(name="zipcode")
    private String zipcode;
    @Column(name="date")
    private String date;
    @Column(name="usersId")
    private long usersId;

    public void setId(long id) {
        this.id = id;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public long getId() {
        return id;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getDate() {
        return date;
    }
}
