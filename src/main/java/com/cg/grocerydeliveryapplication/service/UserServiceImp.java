package com.cg.grocerydeliveryapplication.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.grocerydeliveryapplication.domain.User;
import com.cg.grocerydeliveryapplication.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {
	
	 @Autowired
	 private UserRepository userRepository;
	
	@Override
	public User registerationForm(User user) {	
		return userRepository.save(user);
	}
	
	@Override
	public boolean login(String email, String password) {
		 
		String m= userRepository.findByEmail(email);
		String  p=userRepository.findBypassword(password);
		if(userRepository.findByEmail(email)==null  || userRepository.findBypassword(password)==null) {
			return false;
		}
		else if(m.equals(email)&& p.equals(password))
		{
			return true;				
		}
		
		return false;
	}

}
 
	
