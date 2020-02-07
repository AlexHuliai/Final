package com.capston.caps.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="events")
public class Event {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   @Column(name="street")
    private String street;
   @Column(name="state")
    private String state;
   @Column(name="zipcode")
    private String zipcode;

   @Column(name="time")
    private String time;


    @Column(name="user_email")
    private String user_email;
    @ManyToMany
    @JoinTable(
            name = "event_atendies",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Users> eventUsers;

    public List<Users> getEventUsers() {

        return eventUsers;
    }

    public void setEventUsers(List<Users> eventUsers) {
        this.eventUsers = eventUsers;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_email() {
        return user_email;
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



    public void setTime(String time) {
        this.time = time;
    }

    public void setId(long id) {
        this.id = id;
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



    public String getTime() {
        return time;
    }

    public long getId() {
        return id;
    }

    public Event() {
    }
}
