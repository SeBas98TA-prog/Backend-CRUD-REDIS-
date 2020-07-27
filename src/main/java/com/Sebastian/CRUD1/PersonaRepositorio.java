package com.Sebastian.CRUD1;

import java.util.List;


public interface PersonaRepositorio {
    
	//List<Persona> findAll();
    //Persona findById(Integer id );
    //Persona save(Persona p);
    //void delete(Persona p);
    //long count();
    List<Persona> findAllPersonas();
    Persona findById(Integer id );
    void save(Persona nombre);
    void delete(int id);
    void update(int id, Persona nombre);
}