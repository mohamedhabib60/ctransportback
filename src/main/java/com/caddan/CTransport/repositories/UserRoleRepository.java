package com.caddan.CTransport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caddan.CTransport.model.AppUser;
import com.caddan.CTransport.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole ,Long>{
	
	List<UserRole> findByUser(AppUser user);
	

}
