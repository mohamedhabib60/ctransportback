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
import com.caddan.CTransport.model.Poste;
import com.caddan.CTransport.repositories.PosteRepository;

@RestController
@RequestMapping("app/postes")
public class PosteController {
	
	@Autowired
	private PosteRepository PosteRepository;

	@GetMapping("/postes")
	public List<Poste> getAllPostes() {
		return PosteRepository.findAll();
	}

	@GetMapping("poste/{id}")
	public ResponseEntity<Poste> getPosteById(@PathVariable(value = "id") Long idPoste)
			throws ResourceNotFoundException {
		Poste poste = PosteRepository.findById(idPoste)
				.orElseThrow(() -> new ResourceNotFoundException("Poste not found for this id :: " + idPoste));
		return ResponseEntity.ok().body(poste);
	}

	@PostMapping("/addPoste")
	public Poste createPoste(@Valid @RequestBody Poste poste) {
		return PosteRepository.save(poste);
	}

	
	@PutMapping("/updatePoste")
	public ResponseEntity<Poste> updatePoste(@PathVariable(value = "idPoste") Long idPoste,
			@Valid @RequestBody Poste PosteDetails) throws ResourceNotFoundException {
		Poste poste = PosteRepository.findById(idPoste)
				.orElseThrow(() -> new ResourceNotFoundException("Poste not found for this id :: " + idPoste));

		poste.setTitre(PosteDetails.getTitre());
		final Poste updatedPoste = PosteRepository.save(poste);
		return ResponseEntity.ok(updatedPoste);
	}

	@DeleteMapping("/{id}")
	public Map<String,String> deletePoste(@PathVariable(value = "id") Long idPoste)
			throws ResourceNotFoundException {
		Poste poste = PosteRepository.findById(idPoste)
				.orElseThrow(() -> new ResourceNotFoundException("Poste not found for this id :: " + idPoste));

		PosteRepository.delete(poste);
		Map<String,String> map = new HashMap<String,String>();
		map.put("Deleted", "OK");
		return map;
	}
	
	
	

}
