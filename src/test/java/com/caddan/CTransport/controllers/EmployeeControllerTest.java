package com.caddan.CTransport.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.caddan.CTransport.model.Employee;
import com.caddan.CTransport.repositories.EmployeeRepository;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {


	@Autowired
	Gson gson = new Gson();
	
	 @Autowired
	 private MockMvc mvc;
	 
	 @MockBean
	 private EmployeeRepository employeeRepository;	 
	 
	 /*
	  * Tester l'ajout d'un Domaine
	  * */
	 
	 @Test
	 public void addNewDomaine() throws Exception
	 {
		
		Employee d = new Employee();
	    mvc.perform( MockMvcRequestBuilders
	        
	       .post("/api/v1/employees")
	       .content(gson.toJson(d))
	       .contentType(MediaType.APPLICATION_JSON)
	       .accept(MediaType.APPLICATION_JSON))
	       .andExpect(status().isOk())
	       .andExpect(content().string("Saved"));
	   
	 }
	 
	
	

}
