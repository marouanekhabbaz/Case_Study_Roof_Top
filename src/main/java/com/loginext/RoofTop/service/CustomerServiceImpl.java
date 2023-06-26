package com.loginext.RoofTop.service;

import com.loginext.RoofTop.models.Customer;
import com.loginext.RoofTop.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Override
    public Customer addCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        logger.info("Adding new Customer");
        return  newCustomer;
    }

    @Override
    public Customer findCustomerByPhoneNumber(long phoneNbr) {
        logger.info("Search for existing customer using phoneNumber");
        Customer customer = customerRepository.findByPhoneNbr(phoneNbr);
        return customer;
    }
}
