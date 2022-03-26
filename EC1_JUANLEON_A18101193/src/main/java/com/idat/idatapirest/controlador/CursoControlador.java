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
import com.idat.idatapirest.servicio.CursoService;
import com.idat.idatapirest.servicio.CursoServicioImpl;

@RestController
@RequestMapping("/curso")
public class CursoControlador {
	
	@Autowired
	private CursoService servicio;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<CursoResponseDto>> listar(){
		
		return new ResponseEntity<List<CursoResponseDto>>(servicio.listarCursos(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody CursoRequestDto curso){
		
		servicio.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<CursoResponseDto> cursoPorId(@PathVariable Integer id){
		
		CursoResponseDto curso = servicio.cursoPorId(id);
		if(curso != null) {
			return new ResponseEntity<CursoResponseDto>(curso, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<CursoResponseDto>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		CursoResponseDto curso = servicio.cursoPorId(id);
		if(curso != null) {
			servicio.eliminarCurso(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar (@RequestBody CursoRequestDto curso){
		
		CursoResponseDto cursoEncontrado = servicio.cursoPorId(curso.getIdRequest());
		if(cursoEncontrado != null) {
			servicio.editarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	

}
