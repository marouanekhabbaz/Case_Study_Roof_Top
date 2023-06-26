package com.loginext.RoofTop.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "order_detail")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {

    @Id
    @GeneratedValue
    private Long id;

    private Long driver;

    private Long customer;

    private int orderTime ;

    private int travelTime;

    public OrderDetail(long customer, int orderTime, int travelTime ) {
        this.customer = customer;
        this.orderTime = orderTime;
        this.travelTime = travelTime;
    }
}
