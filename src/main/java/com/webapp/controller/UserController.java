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

import com.webapp.model.User;
import com.webapp.model.UserRoles;
import com.webapp.service.UserRolesService;
import com.webapp.service.UserService;




@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRolesService userRoleService;

    @GetMapping("/list")
    public String listUsers(Model theModel) {
        List < User > theUsers = userService.getUsers();
        theModel.addAttribute("users", theUsers);
        return "list-user";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        User theUser = new User();
        List<UserRoles> theUserRoleList=userRoleService.getUserRoles();
        theModel.addAttribute("user", theUser);
        theModel.addAttribute("userRoles", theUserRoleList);
        return "user-form";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser) {
    	  Date date = new Date();
    	  theUser.setCreatedBy(1);
          theUser.setCreatedDate(date);
          theUser.setActiveFlag("REGD");
          System.out.println(date);
    userService.saveUser(theUser);
        return "redirect:/user/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("userId") int theId,
        Model theModel) {
        User theUser = userService.getUser(theId);
        List<UserRoles> theUserRoleList=userRoleService.getUserRoles();
        Date date = new Date();
        theUser.setUpdatedDate(date);
        theUser.setUpdatedBy(1);
        System.out.println(date);
        theModel.addAttribute("user", theUser);
        theModel.addAttribute("userRoles", theUserRoleList);
        return "update-user";
    }
    
    @GetMapping("/updateFor")
    public String showForm(@RequestParam("userId") int theId,
        Model theModel) {
        User theUser = userService.getUser(theId);
        UserRoles theUserRole=userRoleService.getUserRole(theUser.getRoleId());
        theModel.addAttribute("user", theUser);
        theModel.addAttribute("userRoles", theUserRole);
        return "user-form-dtls";
    }

//    @GetMapping("/delete")
//    public String deleteUser(@RequestParam("userId") int theId) {
//    	userService.deleteUser(theId);
//        return "redirect:/";
//    }

}
