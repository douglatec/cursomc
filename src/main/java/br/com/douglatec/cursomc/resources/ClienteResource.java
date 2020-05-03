package br.com.douglatec.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.douglatec.cursomc.domain.Cliente;
import br.com.douglatec.cursomc.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/clientes")
@Api(value="API REST Clientes")
@CrossOrigin(origins="*")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	//@GetMapping()
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ApiOperation("Retorna as Clientes")
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = clienteService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	

}


/*
 http://localhost:8080/swagger-ui.html#/ ----> Documentação da API
 http://localhost:8080/h2-console/ -----> Banco de dados de teste H2
*/