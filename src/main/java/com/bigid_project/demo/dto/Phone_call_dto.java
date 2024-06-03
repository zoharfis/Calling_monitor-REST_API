package com.bigid_project.demo.dto;

import lombok.Data;

@Data
public class Phone_call_dto {
    private String time;
    private String callType;
    private int duration;
    private String phoneNumber;
}
