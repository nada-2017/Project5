package com.example.salon1.Repository;

import com.example.salon1.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer getCustomerById(Integer id);
}
