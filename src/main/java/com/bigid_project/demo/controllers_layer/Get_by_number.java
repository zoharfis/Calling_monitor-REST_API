package com.bigid_project.demo.controllers_layer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigid_project.demo.entities_layer.Phone_call_entity;
import com.bigid_project.demo.service_layer.Phone_call_service;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("get-by-number")
@RequiredArgsConstructor
public class Get_by_number {
    @Autowired
    private Phone_call_service phone_call_service;

    // this func gets phone_number and return list of all the phone call records of phone_number 


    @GetMapping("/{phone_number}")
    public List<Phone_call_entity> get_phone_call_by_number(@PathVariable String phone_number){
        return phone_call_service.find_records_by_phone(phone_number);
    }
}
