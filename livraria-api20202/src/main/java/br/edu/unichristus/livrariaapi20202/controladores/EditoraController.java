package br.edu.unichristus.livrariaapi20202.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.livrariaapi20202.entidades.Editora;
import br.edu.unichristus.livrariaapi20202.servicos.EditoraService;

@RestController
@RequestMapping("/editoras")
@CrossOrigin(origins = "http://localhost:8080")
public class EditoraController {
	
	@Autowired
	private EditoraService servicoEditoras;
	
	@GetMapping("/todos")
	public List<Editora> buscarTodos() {
		return this.servicoEditoras.buscarTodos();
	}

}
