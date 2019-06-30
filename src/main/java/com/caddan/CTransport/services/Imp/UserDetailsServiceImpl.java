package com.caddan.CTransport.services.Imp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.caddan.CTransport.model.AppUser;
import com.caddan.CTransport.model.UserRole;
import com.caddan.CTransport.repositories.AppUserRepository;
import com.caddan.CTransport.repositories.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	
	private AppUser user;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		AppUser user = userRepository.findByUsername(username);
		this.user=user;
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
	    
		List<UserRole> userRoles = userRoleRepository.findByUser(user);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (UserRole role : userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getNom()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}
	
	public AppUser getUser() {
		return this.user;
	}
}