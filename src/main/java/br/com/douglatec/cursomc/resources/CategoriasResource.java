package br.com.douglatec.cursomc.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Categorias")
@CrossOrigin(origins="*")
public class CategoriasResource {
	
	
	@GetMapping("/categorias")
	@ApiOperation("Retorna as Categorias")
	public String listar() {
		
		return "Rest esta funcionando";
	}
	

}
