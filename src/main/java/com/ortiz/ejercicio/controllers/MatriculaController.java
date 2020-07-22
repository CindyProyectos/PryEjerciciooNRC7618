package com.ortiz.ejercicio.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ortiz.ejercicio.models.entities.Matricula;
import com.ortiz.ejercicio.models.services.IMatriculaService;

@Controller
@RequestMapping(value="/matricula")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService srvMatricula;
	
	//*****************************Metodos **********************************
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Matricula matricula = new Matricula();
		model.addAttribute("title", "Registro de nueva matricula");
		model.addAttribute("matricula", matricula);
		return "matricula/form"; // ubicación de la vista
	}	
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Matricula matricula = srvMatricula.findById(id);
		model.addAttribute("matricula", matricula);
		return "matricula/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Matricula matricula = srvMatricula.findById(id);
		model.addAttribute("matricula", matricula);
		model.addAttribute("title", "Actualizando el registro de la matricula");
		return "matricula/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvMatricula.delete(id);
		return "redirect:/matricula/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Matricula> matriculas = this.srvMatricula.findAll();
		model.addAttribute("matriculas", matriculas);
		model.addAttribute("title", "Listado de matriculas");
		return "matricula/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(@Valid Matricula matricula,BindingResult result, Model model) {
		try {
			if(result.hasErrors()) {
				model.addAttribute("title", "Error al registrar matricula");
				model.addAttribute("matricula", matricula);
				return "matricula/form";
			}
			srvMatricula.save(matricula);
		}catch(Exception ex) {
		}
		return "redirect:/matricula/list";
	}
}
