package com.minsait.livraria.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	// Salvando um cadastro especifico utilizando o metodo save() do CrudRepository
	public void atualizar(long id, @Valid Livro livro) {
		livro.setId(id);
		this.livroRepository.save(livro);
	}
	
	// Listar todos os Livros
	public List<Livro> exibirTodosOsLivros() {
		return this.livroRepository.findAll();
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
