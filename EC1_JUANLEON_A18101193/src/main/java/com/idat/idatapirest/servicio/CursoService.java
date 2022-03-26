package com.idat.idatapirest.servicio;

import java.util.List;

import com.idat.idatapirest.dto.CursoRequestDto;
import com.idat.idatapirest.dto.CursoResponseDto;

public interface CursoService {

	public void guardarCurso(CursoRequestDto c);
	public void eliminarCurso(Integer id);
	public void editarCurso(CursoRequestDto c);
	public List<CursoResponseDto> listarCursos();
	public CursoResponseDto cursoPorId(Integer id);
	
}
