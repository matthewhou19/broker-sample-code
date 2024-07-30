package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerResponseRepository extends JpaRepository<CustomerRespondEntity, Long> , CrudRepository<CustomerRespondEntity, Long>{
    List<CustomerRespondEntity> findByOriginZipCodeAndDestinationZipCode(String originZipCode, String destinationZipCode);

    List<CustomerRespondEntity> findByOriginZipCodeAndDestinationState(String originZipCode, String destinationStateAbbreviation);

    List<CustomerRespondEntity> findByOriginStateAndDestinationState(String originStateAbbreviation, String destinationStateAbbreviation);

    List<CustomerRespondEntity> findByOriginStateAndDestinationZipCode(String originStateAbbreviation, String destinationZipCode);

}
