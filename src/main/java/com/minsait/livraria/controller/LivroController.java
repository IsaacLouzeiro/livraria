package com.minsait.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.livraria.entity.Livro;
import com.minsait.livraria.service.LivroService;

@RestController
@RequestMapping("/api/v1/livraria/livros")

public class LivroController {
	
	private LivroService livroService;
	
	@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}
	
	// Cadastrar Livro
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro cadastraLivro(@Valid @RequestBody Livro livro) {
		return this.livroService.cadastrarLivro(livro);
	}
	
	// Atualizar ou salvar Livro
	@PutMapping("/{id}")
	public Livro atualizar(@PathVariable long id, @Valid @RequestBody Livro livro) {
		this.livroService.atualizar(id, livro);
		return livro;
	}

	// Listar todos os Livros
	@GetMapping
	public List<Livro> exibirTodosOsLivros() {
		return this.livroService.exibirTodosOsLivros();
	}
	
	// Achar Livro por ID
	@GetMapping("/{id}")
	public Livro exibirLivros(@PathVariable("id") long id) {
		return this.livroService.exibirLivrosPorId(id);
	}
	
	// Excluir Livro por ID
	@DeleteMapping("/{id}")
	public void excluirLivros(@PathVariable("id") long id) {
		this.livroService.excluir(id);
	}
}
