package com.example.adressservice.controllers;

import com.example.adressservice.models.Addresses;
import com.example.adressservice.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bernd
 *
 * Controller for RESTful methods in address-table
 */
@RequestMapping("api/address")
@RestController
public class AddressController {

    private final AddressService service;

    /**
     * Wired the controller class with the special AddressService class
     * @param service AddressService with database management methods
     */
    @Autowired
    public AddressController(AddressService service) {
        this.service = service;
    }

    /**
     * Get a list with all saved addresses
     * @return List of all Addresses in the database
     */
    @GetMapping("all")
    public List<Addresses> getAddresses() {
        return this.service.findAllAddresses();
    }

    /**
     * Get an address by the unique id
     * @param id unique id of the address as long
     * @return address which matching the unique id
     */
    @GetMapping("{id}")
    public Addresses getAddressById(@PathVariable("id") long id) {
        return this.service.findAddressById(id);
    }

    /**
     * Create an new Address Entry
     * @param newAddress New address of type Addresses
     * @return the saved entry
     */
    @PostMapping("")
    public Addresses postAddress(@RequestBody Addresses newAddress) {
        return this.service.createAddress(newAddress);
    }

    /**
     * Delete an address matching by the unique id
     * @param id unique id of the address as long
     */
    @DeleteMapping("{id}")
    public void deleteAddressById(@PathVariable("id") long id) {
        this.service.deleteAddressById(id);
    }


}
