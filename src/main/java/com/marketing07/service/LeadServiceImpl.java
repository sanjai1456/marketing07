package com.marketing07.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing07.entities.Lead;
import com.marketing07.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepository;
	
	@Override
	public void saveReg(Lead lead) {
		leadRepository.save(lead);
		
	}
	@Override
	public List<Lead> findAllLeads() {
	List<Lead> leads = leadRepository.findAll();
		return leads;
	}
	@Override
	public void deleteLeadById(long id) {
		leadRepository.deleteById(id);
		
	}
	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepository.findById(id);
		Lead lead = findById.get();
		return lead;
	}
	
}
