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

import com.ortiz.ejercicio.models.entities.Profesor;
import com.ortiz.ejercicio.models.services.IProfesorService;

@Controller
@RequestMapping(value="/profesor")
public class ProfesorController {

	@Autowired 
	private IProfesorService srvProfesor;
	
	@GetMapping(value="/create") //https://localhost:8080/alumno/create
	public String create(Model model) {
		Profesor maestro = new Profesor();
		model.addAttribute("title", "Registro de nuevo profesor");
		model.addAttribute("profesor", maestro);
		return "profesor/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Profesor maestro = srvProfesor.findById(id);
		model.addAttribute("profesor", maestro);
		return "profesor/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Profesor maestro = srvProfesor.findById(id);
		model.addAttribute("profesor", maestro);
		model.addAttribute("title", "Actualizando el registro de " + maestro);
		return "profesor/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvProfesor.delete(id);
		return "redirect:/profesor/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Profesor> profesores = srvProfesor.findAll();
		model.addAttribute("profesores", profesores);
		model.addAttribute("title", "Listado de profesores");
		return "profesor/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(@Valid Profesor maestro, BindingResult result, Model model) {
		try {
			if(result.hasErrors()) {
				model.addAttribute("title", "Error al registrar profesor");
				model.addAttribute("profesor", maestro);
				return "profesor/form";
			}
			srvProfesor.save(maestro);
		}catch(Exception ex){
		}
		return "redirect:/profesor/list";
	}
}
