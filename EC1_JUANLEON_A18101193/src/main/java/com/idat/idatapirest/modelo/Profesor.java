package com.idat.idatapirest.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="profesor")
@Entity
public class Profesor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3445003107268735691L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer idProfesor;
	private String profesor;
	
	
	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="profesor_curso",
	joinColumns = @JoinColumn(name= "id_Profesor", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_Profesor) references profesor(id_Profesor)")),
	inverseJoinColumns = @JoinColumn(name="id_Curso", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_Curso) references curso (id_Curso)"))
			
			)
	private List<Curso> listaCursos = new ArrayList<>();


	public Integer getIdProfesor() {
		return idProfesor;
	}


	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}


	public String getProfesor() {
		return profesor;
	}


	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}


	public List<Curso> getListaCursos() {
		return listaCursos;
	}


	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}
	
	
	

}
