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
import org.springframework.web.bind.annotation.RestController;

import com.caddan.CTransport.exceptions.ResourceNotFoundException;
import com.caddan.CTransport.model.Specialite;
import com.caddan.CTransport.repositories.SpecialiteRepository;

@RestController
@RequestMapping("app/specialites")
public class SpecialiteController {
	
	@Autowired
	private SpecialiteRepository specialiteRepository;

	@GetMapping("/specialites")
	public List<Specialite> getAllSpecialites() {
		return specialiteRepository.findAll();
	}

	@GetMapping("specialite/{id}")
	public ResponseEntity<Specialite> getSpecialiteById(@PathVariable(value = "id") Long idSpecialite)
			throws ResourceNotFoundException {
		Specialite specialite = specialiteRepository.findById(idSpecialite)
				.orElseThrow(() -> new ResourceNotFoundException("Specialite not found for this id :: " + idSpecialite));
		return ResponseEntity.ok().body(specialite);
	}

	@PostMapping("/addSpecialite")
	public Specialite createSpecialite(@Valid @RequestBody Specialite specialite) {
		return specialiteRepository.save(specialite);
	}

	
	@PutMapping("/updateSpecialite")
	public ResponseEntity<Specialite> updateSpecialite(@PathVariable(value = "idSpecialite") Long idSpecialite,
			@Valid @RequestBody Specialite SpecialiteDetails) throws ResourceNotFoundException {
		Specialite specialite = specialiteRepository.findById(idSpecialite)
				.orElseThrow(() -> new ResourceNotFoundException("Specialite not found for this id :: " + idSpecialite));

		specialite.setTitre(SpecialiteDetails.getTitre());
		final Specialite updatedSpecialite = specialiteRepository.save(specialite);
		return ResponseEntity.ok(updatedSpecialite);
	}

	@DeleteMapping("/{id}")
	public Map<String,String> deleteSpecialite(@PathVariable(value = "id") Long idSpecialite)
			throws ResourceNotFoundException {
		Specialite specialite = specialiteRepository.findById(idSpecialite)
				.orElseThrow(() -> new ResourceNotFoundException("Specialite not found for this id :: " + idSpecialite));

		specialiteRepository.delete(specialite);
		Map<String,String> map = new HashMap<String,String>();
		map.put("Deleted", "OK");
		return map;
	}
	
	
	

}
