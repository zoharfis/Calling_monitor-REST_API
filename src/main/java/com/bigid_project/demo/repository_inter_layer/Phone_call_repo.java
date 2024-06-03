package com.bigid_project.demo.repository_inter_layer;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigid_project.demo.entities_layer.Phone_call_entity;

import jakarta.transaction.Transactional;


// this interface made for communicating whit the phone call records table

@Repository
public interface Phone_call_repo extends JpaRepository<Phone_call_entity,Date>{
    
    List<Phone_call_entity> findByPhoneNumber(String phone);
    List<Phone_call_entity> findByDurationGreaterThan(int duration);


    // the func get  an old-phoneNumber and a new-phoneNumber
    // and update the old-phoneNumber
    @Modifying
    @Transactional
    @Query("UPDATE Phone_call_entity p SET p.phoneNumber = :newPhone WHERE p.phoneNumber = :phoneNumber")
    void updatePhoneNumber(@Param("phoneNumber") String phoneNumber, @Param("newPhone") String newPhone);
    
}
 