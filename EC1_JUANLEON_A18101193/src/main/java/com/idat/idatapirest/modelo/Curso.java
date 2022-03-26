package com.idat.idatapirest.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ForeignKey;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Table(name="curso")
@Entity
public class Curso implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6026109738059984351L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer idCurso;
	private String curso;
	private String descripcion;
	
	@ManyToMany (mappedBy = "listaCursos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Profesor> listaProfesores = new ArrayList<>();
	
	
	@ManyToOne
	@JoinColumn(name ="id_Malla", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_Malla) references MALLACURRICULAR (id_Malla)") )
	private MallaCurricular malla;
	
	
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
