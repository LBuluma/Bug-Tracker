package com.webapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.model.UserRoles;
import com.webapp.service.UserRolesService;

@Controller
@RequestMapping("/userroles")
public class UserRolesController {
	@Autowired
	private UserRolesService userRolesService;
	
	@GetMapping("/view")
	public String listUserRoles( Model theModel) {
		List<UserRoles> theUserRoles = userRolesService.getUserRoles();
		theModel.addAttribute("userRoles", theUserRoles);
		return "list-userroles";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		UserRoles theUserRoles= new UserRoles();
		theModel.addAttribute("userRoles", theUserRoles);
		return "project-userrole-form";
	}

	@PostMapping("/saveUserRole")
	public String saveRole( @ModelAttribute("userRole") UserRoles theUserRoles) {
		userRolesService.addNewUserRole(theUserRoles);
		return "redirect:/userroles/view";
	}

	@GetMapping("/updateAssignmentForm")
	public String showFormForUpdate(@RequestParam("roleId") int theId, Model theModel) {
		UserRoles theUserRoles = userRolesService.getUserRole(theId);
		Date date = new Date();
		theUserRoles.setUpdatedDate(date);
		theUserRoles.setUpdatedBy("1");
		System.out.println(date);
		theModel.addAttribute("userRoles", theUserRoles);
		return "project-userrole-form";
	}


}
