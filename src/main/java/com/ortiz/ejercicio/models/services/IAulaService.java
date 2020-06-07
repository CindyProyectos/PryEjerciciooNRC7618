package com.ortiz.ejercicio.models.services;

import java.util.List;

import com.ortiz.ejercicio.models.entities.Aula;

public interface IAulaService {
	
	public void save(Aula aula);
	
	public Aula findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Aula> findAll();
}
