package com.idat.idatapirest.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.idatapirest.dto.MallaCurricularRequestDto;
import com.idat.idatapirest.dto.MallaCurricularResponseDto;
import com.idat.idatapirest.dto.UniversidadResponseDto;
import com.idat.idatapirest.modelo.MallaCurricular;
import com.idat.idatapirest.modelo.Universidad;
import com.idat.idatapirest.repositorio.MallaCurricularRepositorio;

public class MallaCurricularServicioImpl implements MallaCurricularServicio {

	@Autowired
	private MallaCurricularRepositorio repositorio;

	@Override
	public void guardarMalla(MallaCurricularRequestDto m) {

		MallaCurricular malla = new MallaCurricular();

		malla.setIdMalla(m.getIdRequest());
		malla.setAño(m.getAño());

		repositorio.save(malla);

	}

	@Override
	public void eliminarMallar(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public void editarMalla(MallaCurricularRequestDto m) {

		MallaCurricular malla = new MallaCurricular();

		malla.setIdMalla(m.getIdRequest());
		malla.setAño(m.getAño());

		repositorio.saveAndFlush(malla);

	}

	@Override
	public List<MallaCurricularResponseDto> listarMalla() {
		
		List<MallaCurricular> listaMalla = repositorio.findAll();

		List<MallaCurricularResponseDto> listaMallaDto = new ArrayList<>();

		MallaCurricularResponseDto objetoDto = new MallaCurricularResponseDto();

		for (MallaCurricular variable : listaMalla) {

			objetoDto.setIdResponse(variable.getIdMalla());
			objetoDto.setAño(variable.getAño());

			listaMallaDto.add(objetoDto);

		}

		return listaMallaDto;
	}

	@Override
	public MallaCurricularResponseDto MallaPorId(Integer id) {
		
		MallaCurricular malla = repositorio.findById(id).orElse(null);

		MallaCurricularResponseDto mallaDto = new MallaCurricularResponseDto();

		mallaDto.setIdResponse(malla.getIdMalla());
		mallaDto.setAño(malla.getAño());

		return mallaDto;
	}

}
