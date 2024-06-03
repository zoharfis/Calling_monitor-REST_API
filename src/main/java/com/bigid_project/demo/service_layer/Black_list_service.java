package com.bigid_project.demo.service_layer;

import com.bigid_project.demo.entities_layer.Black_list_entity;
import com.bigid_project.demo.repository_inter_layer.Black_list_repo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Black_list_service {
    @Autowired
    private Black_list_repo repo;

    // this func get a path to csv file and insert all the numbers in the file to the black list table 

    public void cvs_to_db(String filePath) throws IOException{
         try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(new File(filePath))))) {
             //'throw' the first row which contains headers
             String[] line = reader.readNext(); 
             while ((line = reader.readNext()) != null) {
                 Black_list_entity entity = new Black_list_entity(line[0]);
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
         



    


    

