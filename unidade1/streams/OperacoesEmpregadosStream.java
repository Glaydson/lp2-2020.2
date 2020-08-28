package unidade1.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OperacoesEmpregadosStream {
    public static void main(String[] args) {
        
        // Criar um array de empregados
        Empregado[] empregados = {
            new Empregado("Aécio", "Neves", 5000, "IT"),
			new Empregado("Tancredo", "Neves", 7600, "IT"),
			new Empregado("Fernando", "Collor", 3587.5, "Vendas"),
			new Empregado("Ciro", "Gomes", 4700.77, "Marketing"),
			new Empregado("Tasso", "Jereissati", 6200, "IT"),
			new Empregado("Camilo", "Santana", 3200, "Vendas"),
			new Empregado("Cid", "Gomes", 4236.4, "Marketing"),
			new Empregado("Cid", "Santana", 4500, "RH")
        };

        // obtém uma lista dos empregados
        List<Empregado> lista = Arrays.asList(empregados);

        // exibe todos os empregados
        System.out.println("Lista completa de empregados:");
        lista.stream().forEach(System.out::println);

        System.out.printf("%nEmpregados ganhando de 4000 a 6000 por mês, ordenados por salário:%n");
        lista.stream()
	        .filter(e -> (e.getSalario() >= 4000 && e.getSalario() <=6000))
            .sorted(Comparator.comparing(Empregado::getSalario))  // ( e -> e.getSalario())
            .forEach(System.out::println);

        System.out.printf("%nPrimeiro empregado que ganha entre 4000 e 6000 por mês:%n%s%n",
        lista.stream()
	        .filter(e -> (e.getSalario() >= 4000 && e.getSalario() <=6000))
            .findFirst()
            .get());

        Comparator<Empregado> primeiroDepoisUltimo = Comparator
                    .comparing(Empregado::getPrimeiroNome)
                    .thenComparing(Empregado::getUltimoNome);
        
        // Ordena os empregados pelo primeiro nome, e depois pelo último nome
        System.out.printf("%nEmpregados em ordem ascendente por primeiro nome e depois pelo último:%n");
        lista.stream()
            .sorted(primeiroDepoisUltimo)
            .forEach(System.out::println);


        // Ordena os empregados pelo primeiro nome em ordem descendente, e depois pelo último nome
        System.out.printf("%nEmpregados em ordem descendente por primeiro nome e depois pelo último:%n");
        lista.stream()
            .sorted(primeiroDepoisUltimo.reversed())
            .forEach(System.out::println);

    }
}