package com.loginext.RoofTop.controller;
import com.loginext.RoofTop.models.Driver;
import com.loginext.RoofTop.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DriverController {

    @Autowired
    DriverService driverService;

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @GetMapping("health")
    public String checkHealth(){
        return "ok";
    }

    @GetMapping("addDriver")
    public ResponseEntity<Driver> addDriver( @RequestParam("name") String name , @RequestParam("phoneNbr") long phoneNbr ){
        logger.info("Creating a new driver");
        Driver driver = new Driver( name, phoneNbr );
        driverService.addDriver(driver);
        return ResponseEntity.ok(driver);
    }

}
