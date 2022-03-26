package com.idat.idatapirest.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.CursoResponseDto;
import com.idat.idatapirest.dto.ProfesorRequestDto;
import com.idat.idatapirest.dto.ProfesorResponseDto;
import com.idat.idatapirest.modelo.Curso;
import com.idat.idatapirest.modelo.Profesor;
import com.idat.idatapirest.repositorio.ProfesorRepositorio;

@Service
public class ProfesorServicioImpl implements ProfesorServicio {

	@Autowired
	private ProfesorRepositorio repositorio;

	@Override
	public void guardarProfesor(ProfesorRequestDto p) {

		Profesor profesor = new Profesor();

		profesor.setIdProfesor(p.getIdRequest());
		profesor.setProfesor(p.getProfesor());

		repositorio.save(profesor);

	}

	@Override
	public void eliminarProfesor(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public void editarProfesor(ProfesorRequestDto p) {
		Profesor profesor = new Profesor();

		profesor.setIdProfesor(p.getIdRequest());
		profesor.setProfesor(p.getProfesor());

		repositorio.saveAndFlush(profesor);

	}

	@Override
	public List<ProfesorResponseDto> listarProfesor() {

		List<Profesor> listaProfesor = repositorio.findAll();

		List<ProfesorResponseDto> listaProfesorDto = new ArrayList<>();

		ProfesorResponseDto objetoDto = new ProfesorResponseDto();

		for (Profesor variable : listaProfesor) {

			objetoDto.setIdResponse(variable.getIdProfesor());
			objetoDto.setProfesor(variable.getProfesor());

			listaProfesorDto.add(objetoDto);

		}

		return listaProfesorDto;
	}

	@Override
	public ProfesorResponseDto ProfesorPorId(Integer id) {
		
		Profesor profesor = repositorio.findById(id).orElse(null);

		ProfesorResponseDto profesorDto = new ProfesorResponseDto();

		profesorDto.setIdResponse(profesor.getIdProfesor());
		profesorDto.setProfesor(profesor.getProfesor());

		return profesorDto;
	}

}
