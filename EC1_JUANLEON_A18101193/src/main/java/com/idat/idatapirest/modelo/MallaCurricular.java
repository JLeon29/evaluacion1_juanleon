package com.idat.idatapirest.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="mallacurricular")
@Entity
public class MallaCurricular implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4620395059713975008L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer idMalla;
	private Integer año;
	
	
	@OneToOne (mappedBy = "mallacurricular")
	private Universidad universidad;
	
	@OneToMany (mappedBy = "malla")
	private List<Curso> cursos = new ArrayList<>();

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public Integer getAño() {
		return año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	

}
