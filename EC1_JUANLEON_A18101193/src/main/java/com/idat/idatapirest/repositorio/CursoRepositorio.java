package com.idat.idatapirest.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.idatapirest.modelo.Curso;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Integer> {

}
