package com.bigid_project.demo.service_layer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigid_project.demo.dto.Phone_call_dto;
import com.bigid_project.demo.entities_layer.Phone_call_entity;
import com.bigid_project.demo.repository_inter_layer.Black_list_repo;
import com.bigid_project.demo.repository_inter_layer.Contact_repo;
import com.bigid_project.demo.repository_inter_layer.Phone_call_repo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Phone_call_service {

    @Autowired
    private Phone_call_repo phone_call_repo;

    @Autowired
    private Contact_repo contact_repo;

    @Autowired
    private Black_list_repo black_list_repo;


    //get a phone_call_dto and insert a new record to the db
    // check if the number is in the black list or contact

    public void add_new_phone_call (Phone_call_dto phonecall_dto){
    try{
       if(black_list_repo.findByPhone(phonecall_dto.getPhoneNumber()).size() > 0){
            System.out.println("the phone number: " + phonecall_dto.getPhoneNumber() + "is in the black list");
            return ;
       }
       boolean is_contact = contact_repo.findByPhone(phonecall_dto.getPhoneNumber()).size() > 0;

       SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
       Date dateTime = dateTimeFormat.parse(phonecall_dto.getTime());
       
       Phone_call_entity new_Call_entity = new Phone_call_entity(dateTime , phonecall_dto.getCallType() , phonecall_dto.getDuration() , phonecall_dto.getPhoneNumber() , is_contact);
       phone_call_repo.save(new_Call_entity);
    }
    catch (ParseException e) {
        e.printStackTrace();
    }
}


    public List<Phone_call_entity> find_records_by_phone(String phone_number){
        return phone_call_repo.findByPhoneNumber(phone_number);
    }
    
    public List<Phone_call_entity> find_records_by_duration(int duration){
        return phone_call_repo.findByDurationGreaterThan(duration);
    }

    public void update_phone_number(String phone_number , String new_phone_number ){
        phone_call_repo.updatePhoneNumber(phone_number, new_phone_number);
    }


    
}
