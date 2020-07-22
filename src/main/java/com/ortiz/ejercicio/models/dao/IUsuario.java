package com.ortiz.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ortiz.ejercicio.models.entities.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByNombre(String nombre);
}
