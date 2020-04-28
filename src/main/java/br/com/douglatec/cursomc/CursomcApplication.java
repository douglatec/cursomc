package br.com.douglatec.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.douglatec.cursomc.domain.Categoria;
import br.com.douglatec.cursomc.domain.Cidade;
import br.com.douglatec.cursomc.domain.Cliente;
import br.com.douglatec.cursomc.domain.Endereco;
import br.com.douglatec.cursomc.domain.Estado;
import br.com.douglatec.cursomc.domain.Produto;
import br.com.douglatec.cursomc.domain.enums.TipoCliente;
import br.com.douglatec.cursomc.repositories.CategoriaRepository;
import br.com.douglatec.cursomc.repositories.CidadeRepository;
import br.com.douglatec.cursomc.repositories.ClienteRepository;
import br.com.douglatec.cursomc.repositories.EnderecoRepository;
import br.com.douglatec.cursomc.repositories.EstadoRepository;
import br.com.douglatec.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRespository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		
		
		Categoria cat1 = new Categoria(null,"informatica");
		Categoria cat2 = new Categoria(null,"escritorio");
		
		Produto p1 = new Produto(null,"computador",2000.00);
		Produto p2 = new Produto(null,"impressora",800.00);
		Produto p3 = new Produto(null,"mause",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRespository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia",est2);
		Cidade c2 = new Cidade(null, "São Paulo",est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria","maria@gmail.com","11997163572",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("22222222222","333333333"));
		
		Endereco e1 = new Endereco(null,"rua flores","300","apt 303","jardim","13080650",cli1,c1);
		Endereco e2 = new Endereco(null,"Av Barao","105","sala 218","centro","13020431",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
		
		
		
		
		
	}
	
	

}
