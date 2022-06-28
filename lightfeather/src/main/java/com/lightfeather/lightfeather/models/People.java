package com.lightfeather.lightfeather.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=3, message="Please add first name")
    private String firstName;
    
    @NotNull
    @Size(min=3, message="Please add last name")
    private String lastName;

    @NotNull(message="Supervisor cannot be empty")
    private String supervisor;

    private String email;
    private int phone;
    private boolean econtact;
    private boolean tcontact;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // CONSTRUCTORS
    public People(){}

    public People(Long id, String firstName, String lastName, String supervisor, String email, int phone, boolean econtact, boolean tcontact) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.supervisor = supervisor;
        this.email = email;
        this.phone = phone;
        this.econtact = econtact;
        this.tcontact = tcontact;
    }

    public People(Long id, String firstName, String lastName, String supervisor, String email, int phone, boolean econtact, boolean tcontact, Date createdAt, Date updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.supervisor = supervisor;
        this.email = email;
        this.phone = phone;
        this.econtact = econtact;
        this.tcontact = tcontact;
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isEcontact() {
        return this.econtact;
    }

    public boolean getEcontact() {
        return this.econtact;
    }

    public void setEcontact(boolean econtact) {
        this.econtact = econtact;
    }

    public boolean isTcontact() {
        return this.tcontact;
    }

    public boolean getTcontact() {
        return this.tcontact;
    }

    public void setTcontact(boolean tcontact) {
        this.tcontact = tcontact;
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
