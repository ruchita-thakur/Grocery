package com.cg.grocerydeliveryapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.grocerydeliveryapplication.domain.User;
import com.cg.grocerydeliveryapplication.repository.UserRepository;
import com.cg.grocerydeliveryapplication.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/grocery")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("/register")
    public User registerationForm(@RequestBody User user){
        return userService.registerationForm(user);
    }
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
		if(userService.login(user.getEmail(), user.getPassword())){
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			if(user.getEmail().equals("Admin") && user.getPassword().equals("Admin12")) {
				return new ResponseEntity<String>("Admin",HttpStatus.OK);
			}
					
			return new ResponseEntity<String>("Valid User Enter",HttpStatus.OK);
			
		}
		else {
		 return new ResponseEntity<String>("Enter Valid data",HttpStatus.BAD_REQUEST);
		
	}
	}
}
