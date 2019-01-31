package com.springboot.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Bikram Baral
 * Date: 1/30/2019
 */
@Document(collection = "contact")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Contact {
    @Id
    private String id;
    private String name, address, city, phone, email;
    private Boolean completed = false;
    private Date createdAt = new Date();


    public Contact() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
       this.completed = completed;
    }

    @Override
    public String toString() {
        return String.format(
                "Contact[id=%s, name='%s', completed='%s']",
                id, name, completed);
    }
}
