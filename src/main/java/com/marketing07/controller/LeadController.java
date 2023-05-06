package com.marketing07.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing07.dto.LeadDto;
import com.marketing07.entities.Lead;
import com.marketing07.service.LeadService;
import com.marketing07.utils.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	//localhost:8080/create
    @RequestMapping("/create")
	public String viewCreateLeadForm() {
		return"create_lead";
	}
    
    @RequestMapping("/saveReg")
    public String saveOneLead(@ModelAttribute Lead lead, Model model) {
    	System.out.println(lead.getFirstName());
		System.out.println(lead.getLastName());
		System.out.println(lead.getEmail());
		System.out.println(lead.getMobile());
    	leadService.saveReg(lead);
    	model.addAttribute("msg", "Lead is saved");
    	emailService.sendEmail(lead.getEmail(), "love", "kutty ponnu");
    	return "create_lead";
    }
    //localhost:8080/list
    @RequestMapping("/list")
    public String getAllLeads(Model model) {
    	 List<Lead> leads = leadService.findAllLeads();
    	model.addAttribute("leads",leads);
    	return "list_leads";
    }
    
    @RequestMapping("/delete")
    public String deleteById(@RequestParam("id") long id,Model model) {
    	leadService.deleteLeadById(id);
    	List<Lead> leads =leadService.findAllLeads();
    	model.addAttribute("leads",leads);
    	return"list_leads";
    }
    @RequestMapping("/update")
    public String updateLead(@RequestParam("id") long id,Model model) {
    	Lead lead =leadService.findLeadById(id);
    	model.addAttribute("lead",lead);
    	return"update_lead";
    }
    @RequestMapping("/editReg")
    public String editReg(LeadDto leadDto,Model model) {
    	Lead lead = new Lead();
    	lead.setId(leadDto.getId());
    	lead.setFirstName(leadDto.getFirstName());
    	lead.setLastName(leadDto.getLastName());
    	lead.setEmail(leadDto.getEmail());
    	lead.setMobile(leadDto.getMobile());
    	leadService.saveReg(lead);
    	List<Lead> leads =leadService.findAllLeads();
    	model.addAttribute("leads",leads);
    	return"list_leads";
    }
    
    
    
    
}
