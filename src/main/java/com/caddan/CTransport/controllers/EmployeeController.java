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
import com.caddan.CTransport.model.Employee;
import com.caddan.CTransport.repositories.EmployeeRepository;


@RestController
@RequestMapping("app/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long idEmployee)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(idEmployee)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + idEmployee));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/addEmployee")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "idEmployee") Long idEmployee,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(idEmployee)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + idEmployee));

		employee.setDateEmbauche(employeeDetails.getDateEmbauche());
		employee.setDateNaissance(employeeDetails.getDateNaissance());
		employee.setEmail(employeeDetails.getEmail());
		employee.setNationnalite(employeeDetails.getNationnalite());
		employee.setNiveauEtude(employeeDetails.getNiveauEtude());
		employee.setNni(employeeDetails.getNni());
		employee.setNomComplet(employeeDetails.getNomComplet());
		employee.setPoste(employeeDetails.getPoste());
		employee.setSalaire(employeeDetails.getSalaire());
		employee.setSpecialite(employeeDetails.getSpecialite());
		employee.setTel(employeeDetails.getTel());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("employee/{id}")
	public Map<String,String> deleteEmployee(@PathVariable(value = "id") Long idEmployee)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(idEmployee)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + idEmployee));

		employeeRepository.delete(employee);
		Map<String,String> map = new HashMap<String,String>();
		map.put("Deleted", "OK");
		return map;
	}
	
	@GetMapping("/search")
	public  List<Employee> searchEmployee(@RequestParam  String term){
		
	List<Employee> list = employeeRepository.chercher(term);

	return list;
	}	
}
