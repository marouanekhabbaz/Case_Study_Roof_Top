package com.loginext.RoofTop.service;

import com.loginext.RoofTop.models.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {

    OrderDetail addOrder(OrderDetail orderDetail);

}
