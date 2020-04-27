package br.com.douglatec.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.douglatec.cursomc.domain.Categoria;
import br.com.douglatec.cursomc.services.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/categorias")
@Api(value="API REST Categorias")
@CrossOrigin(origins="*")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	//@GetMapping()
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ApiOperation("Retorna as Categorias")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = categoriaService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	

}
