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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="materias")
public class Materia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_materia")
	private Integer idmateria;
	
	@Column(name="nombre")
	@NotEmpty
	@Size(max=15)
	private String nombre;
	
	@Column(name="nrc")
	@NotEmpty
	@Size(max=4)
	private String nrc;
	
	@Column(name="creditos")
	private Integer creditos;
	
	@OneToMany(mappedBy="docente", fetch=FetchType.LAZY)
	private List<Aula> aulas;
	
	@JoinColumn(name="fk_area", referencedColumnName="pk_area")
	@ManyToOne
	private Area area;
	
	@JoinColumn(name="fk_semestre", referencedColumnName="pk_semestre")
	@ManyToOne
	private Semestre semestre;
	
	@OneToMany(mappedBy="curso", fetch=FetchType.LAZY)
	private List<Matricula> matriculas;
	
	public Materia() {
		super();
	}
	
	public Materia(Integer id) {
		super();
		idmateria=id;
	}

	public Integer getIdmateria() {
		return idmateria;
	}

	public void setIdmateria(Integer idmateria) {
		this.idmateria = idmateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	
	/*Relacion varios a uno con Area*/
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return nombre + " - " + nrc;
	}
	
}
