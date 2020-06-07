package com.ortiz.ejercicio.models.services;

import java.util.List;

import com.ortiz.ejercicio.models.entities.Profesor;

public interface IProfesorService {
	
	public void save(Profesor maestro);
	
	public Profesor findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Profesor> findAll();
}