package com.caddan.CTransport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caddan.CTransport.model.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser ,Long>{

	AppUser findByUsername(String username);
	
	

}
