package com.bigid_project.demo.controllers_layer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigid_project.demo.dto.Phone_call_dto;
import com.bigid_project.demo.service_layer.Phone_call_service;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("new-record")
@RequiredArgsConstructor
public class New_call {
    @Autowired
    private Phone_call_service phone_call_service;

    @PostMapping
    public void save_new_record(@RequestBody Phone_call_dto phone_call_dto){
        phone_call_service.add_new_phone_call(phone_call_dto);
    }
}
