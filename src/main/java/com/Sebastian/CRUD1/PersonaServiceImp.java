package com.Sebastian.CRUD1;


import java.util.ArrayList;
import java.util.List;
//---Imports----//
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;



@Service
public class PersonaServiceImp implements PersonaRepositorio{

	private static final String KEY = "personas";
	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Integer, Persona> hashOperations;
	
	@Autowired
	private PersonaServiceImp(RedisTemplate<String, Object> redisTemplate){
		this.redisTemplate = redisTemplate;
	}
	
	@PostConstruct
	private void initializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public List<Persona> findAllPersonas() {
		// TODO Auto-generated method stub
		Map<Integer, Persona> map = hashOperations.entries(KEY);
		List<Persona> list = new ArrayList<Persona>(map.values());
		return list;
	}

	@Override
	public Persona findById(Integer id) {
		// TODO Auto-generated method stub
		return hashOperations.get(KEY, id);
	}

	@Override
	public void save(Persona nombre) {
		// TODO Auto-generated method stub
		hashOperations.put(KEY, nombre.getId(), nombre);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		hashOperations.delete(KEY, id);
		
	}

	@Override
	public void update(int id, Persona nombre) {
		// TODO Auto-generated method stub
		hashOperations.put(KEY, id, nombre);
	}

	
	
}
	
	/*@Override
	public Map<Integer, Persona> listar() {
		
		return repositorio.findAll();
	}

	@Override
	public Persona listarID(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Persona editar(Persona p) {
		return repositorio.save(p);
	}

	@Override
	public Persona agregar(Persona p) {
		return repositorio.save(p);
	}

	@Override
	public Persona delete(int id) {
		Persona p= repositorio.findById(id);
		if(p!=null){
			repositorio.delete(p);
		}
		return p;
	}*/

