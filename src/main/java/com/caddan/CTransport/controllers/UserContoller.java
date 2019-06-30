package com.caddan.CTransport.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caddan.CTransport.model.AppUser;
import com.caddan.CTransport.repositories.AppUserRepository;

@RestController
@RequestMapping("app/users")
public class UserContoller {
	
	@Autowired
	AppUserRepository userRepo ;
	@GetMapping("/user")
	public ResponseEntity<AppUser> getUser(HttpServletRequest request) {

		//System.out.println(userRepo.findByUsername(request.getRemoteUser()));
		AppUser temp = new AppUser() ;
		temp = userRepo.findByUsername(request.getRemoteUser());
		temp.setPassword("");
		
		
		
		return ResponseEntity.ok().body(temp);
	}

}
