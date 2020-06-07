package com.ortiz.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ortiz.ejercicio.models.entities.Matricula;

public interface IMatricula extends CrudRepository<Matricula, Integer>{

}
