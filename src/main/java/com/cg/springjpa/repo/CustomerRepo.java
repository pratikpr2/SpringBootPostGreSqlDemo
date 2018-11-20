package com.cg.springjpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.springjpa.model.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long>{

	List<Customer> findByLastName(String lastName);
}
