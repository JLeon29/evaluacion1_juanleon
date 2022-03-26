package com.idat.idatapirest.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.CursoRequestDto;
import com.idat.idatapirest.dto.CursoResponseDto;
import com.idat.idatapirest.modelo.Curso;
import com.idat.idatapirest.repositorio.CursoRepositorio;

@Service
public class CursoServicioImpl implements CursoService {
	
	@Autowired
	private CursoRepositorio repositorio;

	@Override
	public void guardarCurso(CursoRequestDto c) {
		
		Curso curso = new Curso();
		
		curso.setIdCurso(c.getIdRequest());
		curso.setCurso(c.getCursoCurso());
		curso.setDescripcion(c.getDescripcionCurso());

		repositorio.save(curso);

	}

	@Override
	public void eliminarCurso(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public void editarCurso(CursoRequestDto c) {

		Curso curso = new Curso();
		
		curso.setIdCurso(c.getIdRequest());
		curso.setCurso(c.getCursoCurso());
		curso.setDescripcion(c.getDescripcionCurso());
		
		repositorio.saveAndFlush(curso);

	}

	@Override
	public List<CursoResponseDto> listarCursos() {

		List<Curso> listaCursos = repositorio.findAll();
		
		List<CursoResponseDto> listaCursosDto = new ArrayList<>();
		
		CursoResponseDto objetoDto = new CursoResponseDto();
		
		for (Curso variable : listaCursos) {
			
			objetoDto.setIdResponse(variable.getIdCurso());
			objetoDto.setCursoCurso(variable.getCurso());
			objetoDto.setDescripcionCurso(variable.getDescripcion());
			
			listaCursosDto.add(objetoDto);
			
		}
		
		
		return listaCursosDto;
	}

	@Override
	public CursoResponseDto cursoPorId(Integer id) {
		Curso curso = repositorio.findById(id).orElse(null);
		
		CursoResponseDto cursoDto = new CursoResponseDto();
		
		cursoDto.setIdResponse(curso.getIdCurso());
		cursoDto.setCursoCurso(curso.getCurso());
		cursoDto.setDescripcionCurso(curso.getDescripcion());
		
		return cursoDto;
	}

}
