package com.loginext.RoofTop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "driver")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {
    @Id
    @GeneratedValue
    private Long driverId ;

    private Long currentCustomer;

    @Column(unique=true)
    private Long phoneNbr;

    private String name;

    private boolean isBusy;

    private long availableTime;

    public Driver( String name , Long phoneNbr) {
        this.phoneNbr = phoneNbr;
        this.name = name;
    }

}
