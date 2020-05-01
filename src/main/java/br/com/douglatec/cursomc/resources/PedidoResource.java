package br.com.douglatec.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.douglatec.cursomc.domain.Pedido;
import br.com.douglatec.cursomc.services.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/pedidos")
@Api(value="API REST Pedidos")
@CrossOrigin(origins="*")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	//@GetMapping()
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ApiOperation("Retorna as Pedidos")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = pedidoService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	

}


/*
 http://localhost:8080/swagger-ui.html#/ ----> Documentação da API
 http://localhost:8080/h2-console/ -----> Banco de dados de teste H2
*/