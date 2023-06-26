package com.loginext.RoofTop.repository;
import com.loginext.RoofTop.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver getDriverByPhoneNbr(long phoneNbr);

    @Query( value = "  from Driver where IS_BUSY = FALSE  " )
     List<Driver> getNotBusyDriver();

    @Query(value ="  from Driver where AVAILABLE_TIME <= :orderTime order by AVAILABLE_TIME  ")
    List<Driver>  getAvailableDriver(@Param("orderTime") int orderTime);

    @Query(value = "  update Driver \n" +
            "set IS_BUSY = true , AVAILABLE_TIME = :orderTime + (:travelTime * 2)\n" +
            ", CURRENT_CUSTOMER = :customer  \n" +
            "where DRIVER_ID = :id ")
    @Modifying
    int assignOrderToDriver(@Param("id") long id , @Param("travelTime")  int travelTime , @Param("orderTime") int orderTime ,
                            @Param("customer")  long customerId ) ;

}