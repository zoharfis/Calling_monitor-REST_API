package com.bigid_project.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bigid_project.demo.service_layer.Black_list_service;
import com.bigid_project.demo.service_layer.Contact_service;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	@Autowired
    private Black_list_service black_list_service;

	@Autowired
    private Contact_service contact_service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct //	after the initialization process, before the app starts.
	public void loadData() {
		try{
		black_list_service.cvs_to_db("demo\\src\\main\\resources\\blackList.csv");
		contact_service.cvs_to_db("demo\\src\\main\\resources\\contactList.csv");
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
