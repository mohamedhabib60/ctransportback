package com.caddan.CTransport.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caddan.CTransport.exceptions.ResourceNotFoundException;
import com.caddan.CTransport.model.Pret;
import com.caddan.CTransport.repositories.PretRepository;
import com.caddan.CTransport.services.PaiementService;

@RestController
@RequestMapping("app/prets")
public class PretController {
	
	@Autowired
	private PretRepository pretRepository;
	
	@Autowired
	PaiementService pService ;

	@GetMapping("/prets")
	public List<Pret> getAllPrets() {
		return pretRepository.findAll();
	}

	@GetMapping("/pret/{id}")
	public ResponseEntity<Pret> getPretById(@PathVariable(value = "id") Long idPret)
			throws ResourceNotFoundException {
		Pret pret = pretRepository.findById(idPret)
				.orElseThrow(() -> new ResourceNotFoundException("Pret not found for this id :: " + idPret));
		return ResponseEntity.ok().body(pret);
	}

	@PostMapping("/addPret")
	public Pret createPret(@Valid @RequestBody Pret pret) {
		return pretRepository.save(pret);
	}

	
	@PutMapping("/updatePret")
	public ResponseEntity<Pret> updatePret(@PathVariable(value = "idPret") Long idPret,
			@Valid @RequestBody Pret pretDetails) throws ResourceNotFoundException {
		Pret pret = pretRepository.findById(idPret)
				.orElseThrow(() -> new ResourceNotFoundException("Pret not found for this id :: " + idPret));

		pret.setDatePret(pretDetails.getDatePret());
		pret.setEmployee(pretDetails.getEmployee());
		
		pret.setSomme(pretDetails.getSomme());
		pret.setUser(pretDetails.getUser());
	
		
		
		final Pret updatedPret = pretRepository.save(pret);
		return ResponseEntity.ok(updatedPret);
	}

	@DeleteMapping("/pret/{id}")
	public Map<String,String> deletePret(@PathVariable(value = "id") Long idPret)
			throws ResourceNotFoundException {
		Pret pret = pretRepository.findById(idPret)
				.orElseThrow(() -> new ResourceNotFoundException("Pret not found for this id :: " + idPret));

		pretRepository.delete(pret);
		Map<String,String> map = new HashMap<String,String>();
		map.put("Deleted", "OK");
		return map;
	}
	
	@GetMapping("/search")
	public  List<Pret> searchPret(@RequestParam  String term){
		
	List<Pret> list = pretRepository.chercher(term);

	return list;
	}

	
	@PostMapping("/paiePret")
	public Pret payerPret(@RequestBody HashMap<String, String> map) throws ResourceNotFoundException {
		
		return pService.payerPret(Long.parseLong(map.get("idPret")), Float.parseFloat(map.get("somme")), map.get("username"));
	
	
	}
	
	
	

}
