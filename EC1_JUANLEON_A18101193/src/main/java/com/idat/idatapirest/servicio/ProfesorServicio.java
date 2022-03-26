package com.idat.idatapirest.servicio;

import java.util.List;

import com.idat.idatapirest.dto.ProfesorRequestDto;
import com.idat.idatapirest.dto.ProfesorResponseDto;

public interface ProfesorServicio {
	
	public void guardarProfesor(ProfesorRequestDto p);
	public void eliminarProfesor(Integer id);
	public void editarProfesor(ProfesorRequestDto p);
	public List<ProfesorResponseDto> listarProfesor();
	public ProfesorResponseDto ProfesorPorId(Integer id);

}
