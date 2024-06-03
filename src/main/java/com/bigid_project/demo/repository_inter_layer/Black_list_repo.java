package com.bigid_project.demo.repository_inter_layer;
import com.bigid_project.demo.entities_layer.Black_list_entity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// this interface made for communicating whit the black list table

@Repository
public interface Black_list_repo extends JpaRepository<Black_list_entity,String> {
    List<Black_list_entity> findByPhone(String phone);
}
