package com.wagneroliv.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wagneroliv.cursomc.domain.Categoria;
import com.wagneroliv.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired //mecanismo para instanciar automáticamente 'repo'
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		// Buscando BD um id, na Categoria, e retorna um Objeto
		Optional<Categoria> obj = repo.findById(id);
		
		//Retorna obj. Caso não tenha valor, retorna NULL.
		return obj.orElse(null);
	}
}
