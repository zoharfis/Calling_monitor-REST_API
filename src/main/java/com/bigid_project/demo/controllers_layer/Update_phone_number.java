package com.bigid_project.demo.controllers_layer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigid_project.demo.service_layer.Phone_call_service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("update-phone-number")
@RequiredArgsConstructor
public class Update_phone_number {
    @Autowired
    private Phone_call_service phone_call_service;
 
    // the func get  an old-phoneNumber and a new-phoneNumber
    // and call the service class for update the old-phoneNumber

    @PutMapping(value="/{old_phone}/{new_phone}")
    public void update_phone_number(@PathVariable String old_phone, @PathVariable String new_phone) {
        phone_call_service.update_phone_number(old_phone, new_phone);    
    }
}
