package com.idat.idatapirest.servicio;

import java.util.List;

import com.idat.idatapirest.dto.UniversidadRequestDto;
import com.idat.idatapirest.dto.UniversidadResponseDto;


public interface UniversidadServicio {
	
	public void guardarUniversidad(UniversidadRequestDto u);
	public void eliminarUniversidad(Integer id);
	public void editarUniversidad(UniversidadRequestDto u);
	public List<UniversidadResponseDto> listarUniversidad();
	public UniversidadResponseDto UniversiadPorId(Integer id);
	
	
	

}
