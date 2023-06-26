package com.loginext.RoofTop.service;

import com.loginext.RoofTop.models.Driver;
import com.loginext.RoofTop.models.OrderDetail;
import com.loginext.RoofTop.repository.DriverRepository;
import com.loginext.RoofTop.repository.OrderDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailImpl implements OrderDetailService {

    private static final Logger logger = LoggerFactory.getLogger(OrderDetailImpl.class);


    @Autowired
    DriverRepository driverRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    DriverService driverService;

    @Override
    public OrderDetail addOrder(OrderDetail orderDetail) {

        Driver driver = null;
        List<Driver> drivers =driverRepository.getNotBusyDriver();

        if(!drivers.isEmpty()) {
            driver = drivers.get(0);
        }
        else {

        drivers = driverRepository.getAvailableDriver( orderDetail.getOrderTime());
            if(drivers.isEmpty()){
                logger.info("No driver is available");
                return null;

            }
            driver = drivers.get(0);
            logger.info("Found free driver , order will be assigned for driver with Id : {} ", driver.getDriverId());
        }
        driverService.AssignOrder(driver.getDriverId() , orderDetail.getTravelTime() , orderDetail.getOrderTime() , orderDetail.getCustomer() );
        orderDetail.setDriver(driver.getDriverId());
        OrderDetail placedOrder = orderDetailRepository.save(orderDetail);
        logger.info("order saved");

        return placedOrder;
    }

}
