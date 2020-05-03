package br.com.douglatec.cursomc.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglatec.cursomc.domain.Categoria;
import br.com.douglatec.cursomc.repositories.CategoriaRepository;
import br.com.douglatec.cursomc.services.exceptions.ObjectNoFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(()->new ObjectNoFoundException("Objeto não encontrado! ID: "+id+", tipo: "+Categoria.class.getName()));
	}
	
	
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
		
	}
	
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return categoriaRepository.save(obj);
		
	}

}
