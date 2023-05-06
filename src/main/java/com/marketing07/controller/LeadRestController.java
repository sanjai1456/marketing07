package com.marketing07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketing07.dto.LeadDto;
import com.marketing07.entities.Lead;
import com.marketing07.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepository;
	
	
	//localhost:8080/api/leads
	@GetMapping 
	public List<Lead> getAllLeads(){
		List<Lead> leads = (List<Lead>)leadRepository.findAll();
		return leads;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadRepository.save(lead);
	}
	
	//localhost:8080/api/leads/1
	@DeleteMapping("/{id}")
       public void deleteOneLeadById(@PathVariable ("id")long id ) {
    	   leadRepository.deleteById(id);
       }
	
	@PutMapping
	public void updateOneLead(@RequestBody LeadDto leadDto) {
		
		Lead lead= new Lead();
		
		lead.setId(leadDto.getId());
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		
		leadRepository.save(lead);
	}
}
