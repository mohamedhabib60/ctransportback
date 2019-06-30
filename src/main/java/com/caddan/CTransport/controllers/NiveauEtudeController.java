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
import com.caddan.CTransport.model.NiveauEtude;
import com.caddan.CTransport.repositories.NiveauEtudeRepository;

@RestController
@RequestMapping("app/niveauEtudes")
public class NiveauEtudeController {
	
	@Autowired
	private NiveauEtudeRepository NiveauEtudeRepository;

	@GetMapping("/niveauEtudes")
	public List<NiveauEtude> getAllNiveauEtudes() {
		return NiveauEtudeRepository.findAll();
	}

	@GetMapping("niveauEtude/{id}")
	public ResponseEntity<NiveauEtude> getNiveauEtudeById(@PathVariable(value = "id") Long idNiveauEtude)
			throws ResourceNotFoundException {
		NiveauEtude niveauEtude = NiveauEtudeRepository.findById(idNiveauEtude)
				.orElseThrow(() -> new ResourceNotFoundException("NiveauEtude not found for this id :: " + idNiveauEtude));
		return ResponseEntity.ok().body(niveauEtude);
	}

	@PostMapping("/addNiveauEtude")
	public NiveauEtude createNiveauEtude(@Valid @RequestBody NiveauEtude niveauEtude) {
		return NiveauEtudeRepository.save(niveauEtude);
	}

	
	@PutMapping("/updateNiveauEtude")
	public ResponseEntity<NiveauEtude> updateNiveauEtude(@PathVariable(value = "idNiveauEtude") Long idNiveauEtude,
			@Valid @RequestBody NiveauEtude NiveauEtudeDetails) throws ResourceNotFoundException {
		NiveauEtude niveauEtude = NiveauEtudeRepository.findById(idNiveauEtude)
				.orElseThrow(() -> new ResourceNotFoundException("NiveauEtude not found for this id :: " + idNiveauEtude));

		niveauEtude.setTitre(NiveauEtudeDetails.getTitre());
		final NiveauEtude updatedNiveauEtude = NiveauEtudeRepository.save(niveauEtude);
		return ResponseEntity.ok(updatedNiveauEtude);
	}

	@DeleteMapping("/{id}")
	public Map<String,String> deleteNiveauEtude(@PathVariable(value = "id") Long idNiveauEtude)
			throws ResourceNotFoundException {
		NiveauEtude niveauEtude = NiveauEtudeRepository.findById(idNiveauEtude)
				.orElseThrow(() -> new ResourceNotFoundException("NiveauEtude not found for this id :: " + idNiveauEtude));

		NiveauEtudeRepository.delete(niveauEtude);
		Map<String,String> map = new HashMap<String,String>();
		map.put("Deleted", "OK");
		return map;
	}
	
	
	

}
