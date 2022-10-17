package com.webapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.model.TicketHeader;
import com.webapp.service.TicketHeaderService;

@Controller
@RequestMapping("/ticketheader")
public class TicketHeaderController {
	
	@Autowired
	private TicketHeaderService ticketHeaderService;
	
	
	@GetMapping("/view")
	public String viewTickets(@RequestParam("projectId") int projectId, Model theModel) {
		List<TicketHeader> theTicketHeaderList = ticketHeaderService.getTickets(projectId);
		theModel.addAttribute("ticketHeaderList", theTicketHeaderList);
		return "list-tickets";
		
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		TicketHeader theTicketHeader= new TicketHeader();
		theModel.addAttribute("ticketHeader", theTicketHeader);
		return "ticketheader-form";
	}
	
	@PostMapping("/saveAssignment")
	public String saveTicket(@RequestParam("projectId") int projectId, @ModelAttribute("ticketHeader") TicketHeader theTicketHeader) {
		ticketHeaderService.addNewTicket(projectId, theTicketHeader);
		return "redirect:/ticketHeader/view";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("ticketHeaderId") int theId, Model theModel) {
		TicketHeader theTicketHeader = ticketHeaderService.getTicket(theId);
		theModel.addAttribute("ticketHeader", theTicketHeader);
		return "project-ticket-form";
	}



}
