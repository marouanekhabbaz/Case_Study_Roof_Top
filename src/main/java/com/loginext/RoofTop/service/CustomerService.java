package com.loginext.RoofTop.service;
import com.loginext.RoofTop.models.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Customer addCustomer(Customer customer);

    Customer findCustomerByPhoneNumber(long phoneNbr);

}
