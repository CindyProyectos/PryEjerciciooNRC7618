package com.ortiz.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ortiz.ejercicio.models.dao.IProfesor;
import com.ortiz.ejercicio.models.entities.Profesor;

@Service
public class ProfesorService implements IProfesorService{

	@Autowired
	private IProfesor dao;
	
	@Override
	@Transactional
	public void save(Profesor maestro) {
		dao.save(maestro);
	}

	@Override
	@Transactional
	public Profesor findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Profesor> findAll() {
		return (List<Profesor>) dao.findAll();
	}

}
