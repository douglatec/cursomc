package br.com.douglatec.cursomc.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglatec.cursomc.domain.Pedido;
import br.com.douglatec.cursomc.repositories.PedidoRepository;
import br.com.douglatec.cursomc.services.exceptions.ObjectNoFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(()->new ObjectNoFoundException("Objeto não encontrado! ID: "+id+", tipo: "+Pedido.class.getName()));
	}

}
