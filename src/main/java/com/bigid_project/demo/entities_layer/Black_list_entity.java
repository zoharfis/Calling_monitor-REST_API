package com.bigid_project.demo.entities_layer;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

//this class repesent one record in the black list table

@Entity
@Table(name = "Black_list")
@Data
public class Black_list_entity {

    @Id
    @Column(name = "phone")
    private String phone;

    
    public Black_list_entity(){
        this.phone = null;
    }

    public Black_list_entity(String phone){
        this.phone = phone;
    }
}
