package com.idat.idatapirest.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.ProfesorResponseDto;
import com.idat.idatapirest.dto.UniversidadRequestDto;
import com.idat.idatapirest.dto.UniversidadResponseDto;
import com.idat.idatapirest.modelo.Profesor;
import com.idat.idatapirest.modelo.Universidad;
import com.idat.idatapirest.repositorio.UniversidadRepository;

@Service
public class UniversidadServicioImpl implements UniversidadServicio {

	@Autowired
	private UniversidadRepository repositorio;

	@Override
	public void guardarUniversidad(UniversidadRequestDto u) {

		Universidad universidad = new Universidad();

		universidad.setIdUniversidad(u.getIdRequest());
		universidad.setUniversidad(u.getUniversidad());

		repositorio.save(universidad);

	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public void editarUniversidad(UniversidadRequestDto u) {

		Universidad universidad = new Universidad();

		universidad.setIdUniversidad(u.getIdRequest());
		universidad.setUniversidad(u.getUniversidad());

		repositorio.saveAndFlush(universidad);

	}

	@Override
	public List<UniversidadResponseDto> listarUniversidad() {

		List<Universidad> listaUniversidad = repositorio.findAll();

		List<UniversidadResponseDto> listaUniversidadDto = new ArrayList<>();

		UniversidadResponseDto objetoDto = new UniversidadResponseDto();

		for (Universidad variable : listaUniversidad) {

			objetoDto.setIdResponse(variable.getIdUniversidad());
			objetoDto.setUniversidad(variable.getUniversidad());

			listaUniversidadDto.add(objetoDto);

		}

		return listaUniversidadDto;
	}

	@Override
	public UniversidadResponseDto UniversiadPorId(Integer id) {
		
		Universidad universidad = repositorio.findById(id).orElse(null);

		UniversidadResponseDto universidadDto = new UniversidadResponseDto();

		universidadDto.setIdResponse(universidad.getIdUniversidad());
		universidadDto.setUniversidad(universidad.getUniversidad());

		return universidadDto;
	}

}
