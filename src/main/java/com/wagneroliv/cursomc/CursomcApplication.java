package com.wagneroliv.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wagneroliv.cursomc.domain.Categoria;
import com.wagneroliv.cursomc.domain.Cidade;
import com.wagneroliv.cursomc.domain.Cliente;
import com.wagneroliv.cursomc.domain.Endereco;
import com.wagneroliv.cursomc.domain.Estado;
import com.wagneroliv.cursomc.domain.Produto;
import com.wagneroliv.cursomc.domain.TipoCliente;
import com.wagneroliv.cursomc.repositories.CategoriaRepository;
import com.wagneroliv.cursomc.repositories.CidadeRepository;
import com.wagneroliv.cursomc.repositories.ClienteRepository;
import com.wagneroliv.cursomc.repositories.EnderecoRepository;
import com.wagneroliv.cursomc.repositories.EstadoRepository;
import com.wagneroliv.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository EnderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@silva.com", "123456789", TipoCliente.PESSOAFISICA);

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "Centro", "369248157", cli1, c2);
		// Associacao Categoria com Produto
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		// Associacao Produto com Categoria
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		// Associacao Estado com Cidade
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		// Adicionando Telefone ao Cliente
		cli1.getTelefones().addAll(Arrays.asList("321654987", "147258369"));

		// Associacao Cliente ao Endereco
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		// Salvando dados nas Tabelas
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		EnderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
