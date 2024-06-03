package com.bigid_project.demo.repository_inter_layer;
import com.bigid_project.demo.entities_layer.Contact_entity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// this interface made for communicating whit contact table

@Repository
public interface Contact_repo extends JpaRepository<Contact_entity, String> {
    List<Contact_entity> findByPhone(String phone);
}
