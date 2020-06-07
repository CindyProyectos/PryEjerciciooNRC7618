package com.ortiz.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ortiz.ejercicio.models.entities.Alumno;

public interface IAlumno extends CrudRepository<Alumno, Integer>{

}
