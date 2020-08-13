package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.entity.Customer;
import com.company.repository.CustomerRepository;
import com.company.role.CustomerRole;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Transactional(readOnly = true)
    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Customer findByLogin(String login) {
        return customerRepository.findCustomerByLogin(login);
    }
    
    @Transactional
    public boolean addUser(String login, String passHash,
                           String link, CustomerRole role) {
        if (customerRepository.existsByLogin(login))
            return false;

        Customer user = new Customer(login, passHash, link, role);
        customerRepository.save(user);

        return true;
    }

}
