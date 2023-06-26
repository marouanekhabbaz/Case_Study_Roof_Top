package com.loginext.RoofTop.models;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Long customerId;

    @Column(unique=true)
    private Long phoneNbr;

    private String name;

    private String address;

    public Customer( String name ,Long phoneNbr  ) {
        this.phoneNbr = phoneNbr;
        this.name = name;
    }
}
