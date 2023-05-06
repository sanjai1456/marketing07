package com.marketing07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.marketing07.entities.Lead;

public interface LeadRepository  extends JpaRepository<Lead,Long> {

}
