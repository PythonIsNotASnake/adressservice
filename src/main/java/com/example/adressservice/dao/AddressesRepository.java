package com.example.adressservice.dao;

import com.example.adressservice.models.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bernd
 * Interface for database connection to table addresses
 */
@Repository("addresses")
public interface AddressesRepository extends JpaRepository<Addresses, Long> {
}
