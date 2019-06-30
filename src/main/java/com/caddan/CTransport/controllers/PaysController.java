package com.caddan.CTransport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caddan.CTransport.model.Pays;
import com.caddan.CTransport.repositories.PaysRepository;

@RestController
@RequestMapping("app/pays")
public class PaysController {
	
	@Autowired
	private PaysRepository paysRepository;
	
	
	@GetMapping("/pays")
	public List<Pays> getAllPays() {
		return paysRepository.findAll();
	}
	

}
