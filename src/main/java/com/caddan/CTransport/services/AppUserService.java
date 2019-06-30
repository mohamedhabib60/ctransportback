package com.caddan.CTransport.services;

import com.caddan.CTransport.model.AppUser;

public interface AppUserService {

	void save(AppUser user);

	AppUser findByUsername(String username);
}