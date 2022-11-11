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

import com.webapp.dto.PriorityLevelDTO;
import com.webapp.model.PriorityLevel;
import com.webapp.service.PriorityLevelService;

@Controller
@RequestMapping("/priority")
public class PriorityLevelController {

	@Autowired
	private PriorityLevelService priorityLevelService;

	@GetMapping("/view")
	public String listPriorityLevels(Model theModel) {
		List<PriorityLevel> thePriorityLevelList = priorityLevelService.getPriorityLevels();
		theModel.addAttribute("priorityLevelList", thePriorityLevelList);
		return "list-priorityLevel";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		PriorityLevelDTO priorityLevelDTO = new PriorityLevelDTO();
		theModel.addAttribute("priorityLevel", priorityLevelDTO);
		return "project-priorityLevel-form";
	}

	@PostMapping("/savePriority")
	public String savePriority(@ModelAttribute("priorityLevel") 	PriorityLevelDTO priorityLevelDto) {
		priorityLevelService.addNewPriorityLevel(priorityLevelDto);
		return "redirect:/priority/view";
	}
	
	@PostMapping("/updatePriority")
	public String updatePriority(@ModelAttribute("priorityLevel") 	PriorityLevelDTO priorityLevelDto) {
		priorityLevelService.updatePriorityLevel(priorityLevelDto);
		return "redirect:/priority/view";
	}
	

	@GetMapping("/updatePriorityForm")
	public String showFormForUpdate(@RequestParam("priorityLevelId") int theId, Model theModel) {
		PriorityLevelDTO priorityLevelDto = priorityLevelService.getPriorityLevel(theId);
		theModel.addAttribute("priorityLevel", priorityLevelDto);
		return "update-prioritylevel-form";
	}

}
