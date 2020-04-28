package br.com.douglatec.cursomc.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglatec.cursomc.domain.Cliente;
import br.com.douglatec.cursomc.repositories.ClienteRepository;
import br.com.douglatec.cursomc.services.exceptions.ObjectNoFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository categoriaRepository;
	
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(()->new ObjectNoFoundException("Objeto não encontrado! ID: "+id+", tipo: "+Cliente.class.getName()));
	}

}
