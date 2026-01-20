package com.aftersales.aftersalestools.repository;

import com.aftersales.aftersalestools.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByName(String name);

    boolean existsByName(String name);
}

