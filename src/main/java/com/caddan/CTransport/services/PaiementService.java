package com.caddan.CTransport.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caddan.CTransport.exceptions.ResourceNotFoundException;
import com.caddan.CTransport.model.PaiementPret;
import com.caddan.CTransport.model.Pret;
import com.caddan.CTransport.repositories.AppUserRepository;
import com.caddan.CTransport.repositories.PaiementPretRepository;
import com.caddan.CTransport.repositories.PretRepository;

@Service
public class PaiementService {
	@Autowired
	private PretRepository pretRepository;
	
	@Autowired
	private PaiementPretRepository ppRepo ;
	
	@Autowired
	private AppUserRepository userRepo ;
	
	
	//Pour payer un pret 
	public Pret payerPret(Long idPret,float somme, String username) throws ResourceNotFoundException {
		Pret pret = pretRepository.findById(idPret)
				.orElseThrow(() -> new ResourceNotFoundException("Pret not found for this id :: " + idPret));

	    pret.setDernierPaie(somme);
	    pret.setDateDernierPaie(new Date());
	    pret.setPayee(pret.getPayee()+somme);
	    
	    
	    PaiementPret pp = new PaiementPret();
	    
	    pp.setDatePaie(new Date());
	    pp.setPret(pret);
	    pp.setSomme(somme);
	    pp.setUser(userRepo.findByUsername(username));
	    
	    ppRepo.save(pp);
	    
		pretRepository.save(pret);
		
		return pret;
		
	}

}
