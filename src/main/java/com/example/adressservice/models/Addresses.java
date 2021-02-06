package com.example.adressservice.models;

import javax.persistence.*;

/**
 * @author bernd
 *
 * POJO-Class of the addresses table
 */
@Entity
@Table(name = "addresses")
public class Addresses {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    /*@Column(name = "house_number")
    private String houseNumber;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    /*public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }*/
}
