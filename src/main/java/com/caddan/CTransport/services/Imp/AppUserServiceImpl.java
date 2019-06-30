package com.caddan.CTransport.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.caddan.CTransport.model.AppUser;
import com.caddan.CTransport.repositories.AppUserRepository;
import com.caddan.CTransport.services.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void save(AppUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public AppUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}