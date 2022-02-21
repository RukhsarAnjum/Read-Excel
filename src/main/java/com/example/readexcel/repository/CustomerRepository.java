package com.example.readexcel.repository;

import com.example.readexcel.bean.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
