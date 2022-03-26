package com.idat.idatapirest.servicio;

import java.util.List;

import com.idat.idatapirest.dto.MallaCurricularRequestDto;
import com.idat.idatapirest.dto.MallaCurricularResponseDto;


public interface MallaCurricularServicio {
	
	public void guardarMalla(MallaCurricularRequestDto m);
	public void eliminarMallar(Integer id);
	public void editarMalla(MallaCurricularRequestDto m);
	public List<MallaCurricularResponseDto> listarMalla();
	public MallaCurricularResponseDto MallaPorId(Integer id);

}
