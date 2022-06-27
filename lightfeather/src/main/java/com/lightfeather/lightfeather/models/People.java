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
import javax.validation.constraints.Email;
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
    @Size(min=3)
    private String firstName;
    
    @NotNull
    @Size(min=3)
    private String lastName;

    @Email
    private String email;

    private boolean econtact;

    @Size(min=10)
    private int phoneNumber;

    private boolean tcontact;

    @NotNull
    private String supervisor;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // CONSTRUCTORS
    public People(){}

    public People(Long id, String firstName, String lastName, String email, int phoneNumber, String supervisor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.supervisor = supervisor;
    }

    public People(Long id, String firstName, String lastName, String email, boolean econtact, int phoneNumber, boolean tcontact, String supervisor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.econtact = econtact;
        this.phoneNumber = phoneNumber;
        this.tcontact = tcontact;
        this.supervisor = supervisor;
    }

    public People(Long id, String firstName, String lastName, String email, boolean econtact, int number, boolean tcontact, String supervisor, Date createdAt, Date updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.econtact = econtact;
        this.phoneNumber = phoneNumber;
        this.tcontact = tcontact;
        this.supervisor = supervisor;
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

    public String getfirstName() {
        return this.firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return this.lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getphoneNumber() {
        return this.phoneNumber;
    }

    public void setphoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
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
