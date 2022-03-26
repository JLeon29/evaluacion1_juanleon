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

import com.idat.idatapirest.dto.CursoRequestDto;
import com.idat.idatapirest.dto.CursoResponseDto;
import com.idat.idatapirest.dto.ProfesorRequestDto;
import com.idat.idatapirest.dto.ProfesorResponseDto;
import com.idat.idatapirest.servicio.ProfesorServicio;
import com.idat.idatapirest.servicio.ProfesorServicioImpl;

@RestController
@RequestMapping("/profesor")
public class ProfesorControlador {
	
	@Autowired
	private ProfesorServicio servicio;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<ProfesorResponseDto>> listar(){
		
		return new ResponseEntity<List<ProfesorResponseDto>>(servicio.listarProfesor(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ProfesorRequestDto profesor){
		
		servicio.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<ProfesorResponseDto> ProfesorPorId(@PathVariable Integer id){
		
		ProfesorResponseDto profesor = servicio.ProfesorPorId(id);
		if(profesor != null) {
			return new ResponseEntity<ProfesorResponseDto>(profesor, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<ProfesorResponseDto>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ProfesorResponseDto profesor = servicio.ProfesorPorId(id);
		if(profesor != null) {
			servicio.eliminarProfesor(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar (@RequestBody ProfesorRequestDto profesor){
		
		ProfesorResponseDto profesorEncontrado = servicio.ProfesorPorId(profesor.getIdRequest());
		if(profesorEncontrado != null) {
			servicio.editarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	

}
