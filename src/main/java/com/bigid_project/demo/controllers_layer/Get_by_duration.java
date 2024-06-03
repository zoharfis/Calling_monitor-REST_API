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
@RequestMapping("get-by-duration")
@RequiredArgsConstructor
public class Get_by_duration {
   
    @Autowired
    private Phone_call_service phone_call_service;

    // this func gets duration and return list of all the phone call records that thier.duration > duration

    @GetMapping("/{duration}")
    public List<Phone_call_entity> get_phone_call_by_duration(@PathVariable String duration){
        int int_duration = -1;
        try {
            // Convert the string to an int
            int_duration = Integer.parseInt(duration);} 
            catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(int_duration >= 0){
        return phone_call_service.find_records_by_duration(int_duration);
        }  
        return null;
    }


    
}
