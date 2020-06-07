package com.ortiz.ejercicio.models.services;

import java.util.List;

import com.ortiz.ejercicio.models.entities.Area;

public interface IAreaService {
	
	public void save(Area area);
	
	public Area findById(Integer id);
	
	public void delete (Integer id);
	
	public List<Area> findAll();
}
