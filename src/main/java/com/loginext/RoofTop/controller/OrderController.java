package com.loginext.RoofTop.controller;
import com.loginext.RoofTop.models.Customer;
import com.loginext.RoofTop.models.OrderDetail;
import com.loginext.RoofTop.service.CustomerService;
import com.loginext.RoofTop.service.OrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    CustomerService customerService;

    @GetMapping("placeOrder")
    public ResponseEntity<String> placeOrder(@RequestParam("time") int orderTime , @RequestParam("travelDuration") int travelTime ,
                                                    @RequestParam("customerName") String name ,  @RequestParam("customerPhone") long phoneNbr
                                                  ){
        logger.info("Start placing order");
        Customer customer = customerService.findCustomerByPhoneNumber(phoneNbr);

        if(customer == null){
        logger.info("No existing customer with this phone number , creating a new customer");
            customer  = new Customer(name , phoneNbr);
            customer =  customerService.addCustomer(customer);
        }
        long customerId = customer.getCustomerId();
        OrderDetail orderDetail = new OrderDetail(customerId ,orderTime , travelTime );

        OrderDetail newOrder =  orderDetailService.addOrder(orderDetail);

        if(newOrder == null){
          return   ResponseEntity.ok( "No food" );
        }

        return ResponseEntity.ok(newOrder.toString());
    }

}
