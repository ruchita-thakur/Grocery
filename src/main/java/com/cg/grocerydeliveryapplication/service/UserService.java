package com.cg.grocerydeliveryapplication.service;

import com.cg.grocerydeliveryapplication.domain.User;

public interface UserService {

	User registerationForm(User user);
	boolean login(String email,String password);
	
	
}
