package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.dto.UserDTO;
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
    public String saveUser(@ModelAttribute("user") UserDTO userDto) {
    	System.out.println("saveUser:" +userDto.getRoleId());
    userService.saveUser(userDto);
        return "redirect:/user/list";
    }
    
    
    @PostMapping(value="/updateUser")
    public String updateUser(@ModelAttribute("user") UserDTO userDto) {
      userService.updateUser(userDto);
        return "redirect:/user/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("userId") int theId,
        Model theModel) {
        UserDTO userDto = userService.getUser(theId);
        List<UserRoles> userRoles = userRoleService.getUserRoles();
        theModel.addAttribute("user", userDto);
        theModel.addAttribute("userRoles", userRoles);
        return "update-user";
    }
    
    @GetMapping("/updateFor")
    public String showForm(@RequestParam("userId") int theId,
        Model theModel) {
        UserDTO theUser = userService.getUser(theId);
        theModel.addAttribute("user", theUser);
        return "user-form-dtls";
    }

//    @GetMapping("/delete")
//    public String deleteUser(@RequestParam("userId") int theId) {
//    	userService.deleteUser(theId);
//        return "redirect:/";
//    }

}
