package com.bigid_project.demo.entities_layer;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;


//this class repesent one record in the contact table

@Entity
@Table(name = "Contact_list")
@Data
public class Contact_entity {
    
    @Id
    @Column(name = "phone")
    public String phone;

    @Column(name = "name")
    public String name;

    public Contact_entity(){
        phone = null;
        name = null;
    }

    public Contact_entity(String name , String phone){
        this.phone = phone;
        this.name = name;
    }
}
