package com.idat.idatapirest.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idatapirest.dto.ProfesorRequestDto;
import com.idat.idatapirest.dto.ProfesorResponseDto;
import com.idat.idatapirest.dto.UniversidadRequestDto;
import com.idat.idatapirest.dto.UniversidadResponseDto;
import com.idat.idatapirest.servicio.UniversidadServicio;

@RestController
@RequestMapping("/universidad")
public class UniversidadControlador {
	
	@Autowired
	private UniversidadServicio servicio;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<UniversidadResponseDto>> listar(){
		
		return new ResponseEntity<List<UniversidadResponseDto>>(servicio.listarUniversidad(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody UniversidadRequestDto universidad){
		
		servicio.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<UniversidadResponseDto> UniversidadPorId(@PathVariable Integer id){
		
		UniversidadResponseDto universidad = servicio.UniversiadPorId(id);
		if(universidad != null) {
			return new ResponseEntity<UniversidadResponseDto>(universidad, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<UniversidadResponseDto>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UniversidadResponseDto universidad = servicio.UniversiadPorId(id);
		if(universidad != null) {
			servicio.eliminarUniversidad(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar (@RequestBody UniversidadRequestDto universidad){
		
		UniversidadResponseDto universidadEncontrada = servicio.UniversiadPorId(universidad.getIdRequest());
		if(universidadEncontrada != null) {
			servicio.editarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	

}
