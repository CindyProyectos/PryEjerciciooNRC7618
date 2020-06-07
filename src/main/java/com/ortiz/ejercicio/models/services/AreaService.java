package com.ortiz.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ortiz.ejercicio.models.dao.IArea;
import com.ortiz.ejercicio.models.entities.Area;

@Service
public class AreaService implements IAreaService{

	@Autowired
	private IArea dao;
	
	@Override
	@Transactional
	public void save(Area area) {
		dao.save(area);
	}

	@Override
	@Transactional
	public Area findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Area> findAll() {
		return (List<Area>) dao.findAll();
	}
	
}
