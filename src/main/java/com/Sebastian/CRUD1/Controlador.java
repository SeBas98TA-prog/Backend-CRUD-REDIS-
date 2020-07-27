package com.Sebastian.CRUD1;


import java.util.List;
//--Imports--//
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) 
@RestController
@RequestMapping( "/redis/personas")
public class Controlador {

	@Autowired
	private PersonaServiceImp personaServiceImp;

	@PostMapping
	public Persona saveNewPersona(@RequestBody Persona persona) {
		 personaServiceImp.save(persona);
		 return persona;
		
	}


	@GetMapping(path = "/{id}")
	public Persona fetchStudent(@PathVariable("id") int id) {
		return personaServiceImp.findById(id);
	}
	
	
	@DeleteMapping(path = "/{id}")
	public boolean deleteOldPincode(@PathVariable("id") int id) {
		personaServiceImp.delete(id);
		return true;  
	}
	

	@GetMapping 
	public  List<Persona> fetchAllPersonas() {
		return personaServiceImp.findAllPersonas();
	}
	

	@PutMapping(path = "{id}")
	public Persona updatePersona(@PathVariable("id") int id,@RequestBody Persona persona) {
		personaServiceImp.update(id, persona);
		return persona;  
	}
	
}

