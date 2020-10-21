package br.edu.unichristus.livrariaapi20202;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.livrariaapi20202.entidades.Cliente;
import br.edu.unichristus.livrariaapi20202.entidades.Endereco;
import br.edu.unichristus.livrariaapi20202.servicos.ClienteService;

//@SpringBootApplication
public class OperacoesMongoDbApplication implements CommandLineRunner {

	@Autowired
	private ClienteService servicoClientes;

	public static void main(String[] args) {
		SpringApplication.run(OperacoesMongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.servicoClientes.removerTodos();
		Endereco end1 = new Endereco("Rua 1", 34, "Fortaleza", "60.000-300");
		Endereco end2 = new Endereco("Rua 2", 100, "Manaus", "92.000-300");
		List<Endereco> enderecosMaria = new ArrayList<>();
		enderecosMaria.add(end1);
		enderecosMaria.add(end2);
		Cliente maria = new Cliente("Maria", "maria@email.com", LocalDate.of(1987, 10, 15), enderecosMaria);

		Endereco end3 = new Endereco("Rua 3", 134, "Fortaleza", "60.000-300");
		Endereco end4 = new Endereco("Rua 4", 100, "Recife", "81.000-300");
		List<Endereco> enderecosJoao = new ArrayList<>();
		enderecosJoao.add(end3);
		enderecosJoao.add(end4);
		Cliente joao = new Cliente("João", "joao@email.com", LocalDate.of(2000, 11, 20), enderecosJoao);

		this.servicoClientes.salvar(maria);
		this.servicoClientes.salvar(joao);

	}

}
