package com.ortiz.ejercicio.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="areas")
public class Area implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_area")
	private Integer idarea;
	
	@Column(name="nombre")
	@NotEmpty
	@Size(max=20)
	private String nombre;

	@Column(name="coordinador")
	@NotEmpty
	@Size(max=35)
	private String coordinador;
	
	public Area() {
		super();
	}
	
	public Area(Integer id) {
		super();
		this.idarea=id;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(String coordinador) {
		this.coordinador = coordinador;
	}

	/*Relacion uno a varios con Materia*/

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	//mappedBy debe ser un atributo en la clase relacionada
	
	@OneToMany(mappedBy= "area", fetch=FetchType.LAZY)
	private List<Materia> materias;
}
