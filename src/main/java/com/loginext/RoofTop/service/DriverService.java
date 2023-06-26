package com.loginext.RoofTop.service;

import com.loginext.RoofTop.models.Driver;
import org.springframework.stereotype.Service;

@Service
public interface DriverService {
    Driver addDriver(Driver driver);

    Driver getDriverByPhoneNumber(long phone);

    int AssignOrder(long id, int travelTime, int orderTime , long customerId );


}
