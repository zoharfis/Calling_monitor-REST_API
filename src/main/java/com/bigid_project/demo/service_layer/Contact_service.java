package com.bigid_project.demo.service_layer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigid_project.demo.entities_layer.Contact_entity;
import com.bigid_project.demo.repository_inter_layer.Contact_repo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Contact_service {
    @Autowired
    private Contact_repo repo;

    // this func get a path to csv file and insert all the numbers in the file to the contact table

    public void cvs_to_db(String filePath) throws IOException{
         try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(new File(filePath))))) {
             //'throw' the first row which contains headers
             String[] line = reader.readNext(); 
             while ((line = reader.readNext()) != null) {
                 Contact_entity entity = new Contact_entity(line[0] , line[1]);
                 repo.save(entity);
             }
         } catch (CsvValidationException e) {
             e.printStackTrace();
 
         } 
        catch (IOException e) {
             e.printStackTrace();
         }
         }
}
