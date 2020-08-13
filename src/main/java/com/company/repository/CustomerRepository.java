package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findCustomerByLogin(String login);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false " +
            "END FROM Customer u WHERE u.login = :login")
    boolean existsByLogin(@Param("login") String login);
}
