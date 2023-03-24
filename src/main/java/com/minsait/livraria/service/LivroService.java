package com.minsait.livraria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.minsait.livraria.entity.Livro;
import com.minsait.livraria.repository.LivroRepository;

@Service
public class LivroService {
	
	private LivroRepository livroRepository;

	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	// Cadastrar Livro
	public Livro cadastrarLivro(Livro livro) {
		return this.livroRepository.save(livro);
	}
	
	// Listar todos os Livros
	public List<Livro> exibirTodosOsLivros() {
		List<Livro> livro = new ArrayList<Livro>();
		this.livroRepository.findAll().forEach(livro1 -> livro.add(livro1));
		return livro;
	}
	
	// Achar Livro por ID
	public Livro exibirLivrosPorId(long id) {
		return this.livroRepository.findById(id).get();
	}
	
	// Excluir Livro por ID
	public void excluir(long id) {
		this.livroRepository.deleteById(id);
	}
	
}
