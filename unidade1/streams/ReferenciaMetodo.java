package unidade1.streams;

import java.io.PrintStream;
import java.util.Objects;
import java.util.stream.Stream;

public class ReferenciaMetodo {

    public static void main(String[] args) {
        PrintStream log = System.out;

        String[][] citacoes = new String[][] { { "Hamlet Ato 3 Cena 1", "Hamlet", "Ser ou não ser" },
                { "Hamlet Ato 3 Cena 2", "Hamlet", null },
                { "Romeu e Julieta Ato 2 Cena 2", "Julieta", "Romeu!, Romeu! Onde está você, Romeu?" },
                { "Ricardo III Ato 1 Cena 2", "Ricardo III", "Agora é o inverno dos descontentes" },
                { "Hamlet Ato 1 Cena 3", "Polonius", "Sobretudo, seja verdadeiro contigo mesmo" },
                { "Henrique IV Parte 2 Ato 3 Cena 2", "Feeble", "Um homem só pode morrer uma vez" },
                { "O Mercador de Veneza Ato 2 Cena 7", "Morocco", "Nem tudo que reluz é ouro" } };

        // Processa o stream sem usar referência de método
        Stream.of(citacoes).map(c -> c[2]) // Ficam somente as citações
                .filter(c -> Objects.nonNull(c)) // Método estático
                .peek(c -> log.println(c)) // Método de instância de um objeto específico
                .map(c -> c.toUpperCase()) // Método de instância de um objeto arbitrário
                .map(c -> new Citacao(c)) // Construtor
                .forEach(c -> log.println(c.getCitacao()));

        // Processa o stream usando referência de método
        Stream.of(citacoes).map(c -> c[2]) // Ficam somente as citações
                .filter(Objects::nonNull) // Método estático
                .peek(log::println) // Método de instância de um objeto específico
                .map(String::toUpperCase) // Método de instância de um objeto arbitrário
                .map(Citacao::new) // Construtor
                .forEach(c -> log.println(c.getCitacao()));

    }

}
