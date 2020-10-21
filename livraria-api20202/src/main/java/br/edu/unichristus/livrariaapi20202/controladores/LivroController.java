package br.edu.unichristus.livrariaapi20202.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.livrariaapi20202.entidades.Livro;
import br.edu.unichristus.livrariaapi20202.servicos.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService servicoLivros;
	
	@GetMapping("/todos")
	public List<Livro> buscarTodos() {
		return servicoLivros.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Livro buscarPeloID(@PathVariable Long id) {
		return servicoLivros.buscarPeloID(id);
	}

}
