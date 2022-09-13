package com.webapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.model.TicketComment;
import com.webapp.model.TicketHeader;
import com.webapp.service.TicketCommentService;

@Controller
@RequestMapping("/ticketComment")
public class TicketCommentController {
	@Autowired
	private TicketCommentService ticketCommentService;
	
	
	@GetMapping("/view")
	public String listTicketComments(@RequestParam("ticketHeaderId") int ticketHeaderId, Model theModel) {
		List<TicketComment> theTicketCommentList = ticketCommentService.getTicketComments(ticketHeaderId);
		theModel.addAttribute("ticketCommentList", theTicketCommentList);
		return "list-comments";
		
	}
	
	@PostMapping("/saveComment")
	public String saveComment(@RequestParam("ticketHeaderId") int ticketHeaderId, @RequestParam("ticketComment") TicketComment theTicketComment) {
		Date date = new Date();
		theTicketComment.setCreatedBy(1);
		theTicketComment.setCreatedDate(date);
		ticketCommentService.addNewTicketComment(ticketHeaderId, theTicketComment);
		return "redirect:/ticketComment/view";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		TicketComment theTicketComment = new TicketComment();
		theModel.addAttribute("ticketComment", theTicketComment);
		return "project-comment-form";
	}
	
	@GetMapping("/updateCommentForm")
	public String showFormForUpdate(@RequestParam("commentId") int theId, Model theModel) {
		TicketComment theTicketComment = ticketCommentService.getTicketComment(theId);
		Date date = new Date();
		theTicketComment.setUpdatedDate(date);
		theTicketComment.setUpdatedBy(1);
		System.out.println(date);
		theModel.addAttribute("ticketComment", theTicketComment);
		return "project-comment-form";
	}
	


}
