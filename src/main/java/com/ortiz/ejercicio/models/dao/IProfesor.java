package com.ortiz.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ortiz.ejercicio.models.entities.Profesor;

public interface IProfesor extends CrudRepository<Profesor, Integer>{

}
