package com.example.homework7.customer;

import com.example.homework7.exception.PasswordException;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.util.List;

@Entity
@NoArgsConstructor
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String username;
    private String password;
    private String name;
    private String country;
    private String city;

    @OneToMany
    private List<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) throws PasswordException {
        if(password.length() > 5 && password.contains("!")
                || password.contains("@") || password.contains("#")
                || password.contains("$") || password.contains("%")
                || password.contains("6") || password.contains("^")
                || password.contains("&") || password.contains("*")) {
            this.password = password;
        }
        else throw new PasswordException("Password must contain at least " +
                "one of the following: !, @, #, $, %, 6, ^, &, *");
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
