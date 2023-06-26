package com.loginext.RoofTop.service;

import com.loginext.RoofTop.models.Driver;
import com.loginext.RoofTop.repository.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService{

    private static final Logger logger = LoggerFactory.getLogger(DriverServiceImpl.class);


    @Autowired
    DriverRepository driverRepository;


    @Override
    public Driver addDriver(Driver driver) {
        Driver returnedDriver =  driverRepository.save(driver);
        logger.info("Adding new driver");

        return returnedDriver;
    }

    @Override
    public Driver getDriverByPhoneNumber(long phone) {
        logger.info("Searching for driver using phone Nbr ");
        Driver driver = driverRepository.getDriverByPhoneNbr(phone);
        return driver;
    }

    @Override
    public int AssignOrder(long id, int travelTime, int orderTime , long customerId ) {

        logger.info("Assigning order to the driver ");

        int driverId = driverRepository.assignOrderToDriver(id , travelTime , orderTime , customerId );

        return  driverId;

    }

}
