package com.capstone.caps.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="events")
public class Event {
    @Column(name="street")
    private String street;
    @Column(name="state")
    private String state;
    @Column(name="city")
    private String city;
    @Column(name="zipcode")
    private String zipcode;
    @Column(name="date")
    private Date date;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="event_id")
    private long event_id;
    @Column(name="user_id")
    private long user_id;

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Date getDate() {
        return date;
    }

    public long getEvent_id() {
        return event_id;
    }

    public Event() {
    }
}
