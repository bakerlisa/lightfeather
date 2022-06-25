package com.lightfeather.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Size(min=3)
    private String fname;

    @Size(min=3)
    private String lname;

    @Email
    private String email;

    @Size(min=10)
    private int number;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // CONSTRUCTORS
    public People() {
    
    }

    public People(Long id, String fname, String lname, String email, int number) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.number = number;
    }

    public People(Long id, String fname, String lname, String email, int number, Date createdAt, Date updatedAt) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.number = number;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    
    // GETTERS / SETTERS
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}