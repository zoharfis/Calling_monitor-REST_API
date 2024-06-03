package com.bigid_project.demo.entities_layer;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//this class repesent one record in the Phone call records table

@Entity
@Table(name = "phone_call")
@Data
public class Phone_call_entity {
    
    @Id
    @Column (name = "time")
    private Date time;

    @Column (name = "callType")
    private String callType; 

    @Column (name = "duration")
    private int duration;
    
    @Column (name = "phoneNumber")
    private String phoneNumber;

    @Column (name = "savedContact")
    private boolean savedContact;
    

    public Phone_call_entity(){
        this.time = null;
        this.callType = null;
        this.duration = 0;
        this.phoneNumber = null;
        this.savedContact = false;
    }

    public Phone_call_entity(Date Date , String in_or_out , int duration , String phone_number , boolean is_contact ){
        this.time = Date;
        this.callType = in_or_out;
        this.duration = duration;
        this.phoneNumber = phone_number;
        this.savedContact = is_contact;
    }
}
