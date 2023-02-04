package com.webapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.facade.AuthenticationFacade;
import com.webapp.service.ApplicationUserService;

@Controller
public class HomeController {
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
    
	@RequestMapping(value="/home")
	public ModelAndView homePage(Model model, HttpServletResponse response,  HttpSession session) throws IOException{
		System.out.println("homePage: IN");
		session.setAttribute("userId",authenticationFacade.getUserIdFromAuth());
		session.setAttribute("userRole",authenticationFacade.getUserRoleFromAuth());
		session.setAttribute("userInfo", session);
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/")
	public ModelAndView welcomePage(HttpServletResponse response) throws IOException{
		System.out.println("welcomePage: IN");
		return new ModelAndView("welcome");
	}
	
	
}
