package com.example.adressservice.services;

import com.example.adressservice.dao.AddressesRepository;
import com.example.adressservice.models.Addresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bernd
 *
 * Methods for managing the addresses table
 */
@Service
public class AddressService {

    private final AddressesRepository addressesRepository;

    /**
     * Wired the AddressService class with the Repository
     * @param addressesRepository
     */
    @Autowired
    public AddressService(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    /**
     * Get a list with all saved addresses
     * @return List of all Addresses in the database
     */
    public List<Addresses> findAllAddresses() {
        List<Addresses> addresses = this.addressesRepository.findAll();
        return addresses;
    }

    /**
     * Get an address by the unique id
     * @param id unique id of the address as long
     * @return address which matching the unique id
     */
    public Addresses findAddressById(long id) {
        try {
            return this.addressesRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Create an new Address Entry
     * @param newAddress New address of type Addresses
     * @return the saved entry
     */
    public Addresses createAddress(Addresses newAddress){
        return this.addressesRepository.save(newAddress);
    }

    /**
     * Delete an address matching by the unique id
     * @param id unique id of the address as long
     */
    public void deleteAddressById(long id) {
        this.addressesRepository.deleteById(id);
    }

}
