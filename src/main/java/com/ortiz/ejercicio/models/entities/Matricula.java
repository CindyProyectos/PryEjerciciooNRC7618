package com.ortiz.ejercicio.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="matriculas")
public class Matricula implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_matricula")
	private Integer idmatricula;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fecha;
	
	@Column(name="costo")
	private Float costo;
	
	@Column(name="tipo")
	@NotEmpty
	@Size(max=15)
	private String tipo;
	
	@JoinColumn(name="fk_estudiante", referencedColumnName="pk_alumno")
	@ManyToOne
	private Alumno estudiante;
	
	@JoinColumn(name="fk_curso", referencedColumnName="pk_materia")
	@ManyToOne
	private Materia curso;	

	public Matricula() {
		super();
	}

	public Matricula(Integer id) {
		super();
		this.idmatricula=id;
	}

	public Integer getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(Integer idmatricula) {
		this.idmatricula = idmatricula;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Alumno getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Alumno estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getCurso() {
		return curso;
	}

	public void setCurso(Materia curso) {
		this.curso = curso;
	}
	
	public String fecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");		
		return sdf.format(fecha.getTime());
	}
}
