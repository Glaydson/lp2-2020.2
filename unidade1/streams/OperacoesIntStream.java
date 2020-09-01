package unidade1.streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OperacoesIntStream {

    public static void main(String[] args) {
        int[] valores = { 2, 10, 6, 1, 4, 50, 60, 7, 0, 9, 15, 38 };

        // Imprimir os valores do array
        IntStream.of(valores).forEach(v -> System.out.printf("%d ", v));
        System.out.println();

        // Algumas operações com inteiros
        System.out.printf("Quantidade de elementos: %d%n", IntStream.of(valores).count());

        OptionalInt menorValor = IntStream.of(valores).min();
        if (menorValor.isPresent()) {
            System.out.println(menorValor.getAsInt());
        } else {
            System.out.println("O array está vazio");
        }

        System.out.printf("Mínimo: %d%n", IntStream.of(valores).min().getAsInt());
        System.out.printf("Máximo: %d%n", IntStream.of(valores).max().getAsInt());
        System.out.printf("Soma usando método sum(): %d%n", IntStream.of(valores).sum());
        System.out.printf("Média: %.2f%n", IntStream.of(valores).average().getAsDouble());

        System.out.printf("%nSoma usando método reduce(): %d%n", IntStream.of(valores).reduce(0, (x, y) -> x + y));
        System.out.printf("%nSoma dos quadrados usando método reduce(): %d%n",
                IntStream.of(valores).reduce(0, (x, y) -> x + y * y));
        System.out.printf("%nProduto dos valores usando método reduce(): %d%n", 
                IntStream.of(valores).reduce(1, (x, y) -> x * y));

            

        // valores pares exibidos em ordem
        System.out.printf("%nValores pares exibidos em ordem: ");
        IntStream.of(valores).filter(valor -> valor % 2 == 0).map(i -> -i).sorted().map(i -> -i) // truque para ordenar
                                                                                                 // em ordem
                                                                                                 // descrescente
                // .sorted()
                .forEach(valor -> System.out.printf("%d ", valor));
        System.out.println();

        // Valores ímpares multiplicados por 10 e exibidos em ordem crescente
        System.out.printf("%nValores ímpares multiplicados por 10 e exibidos em ordem crescente: ");
        IntStream.of(valores)
            .filter(valor -> valor % 2 != 0) // impares
            .map(valor -> valor * 10) // multiplicados por 10
            .sorted() // em ordem crescente
            .forEach(valor -> System.out.printf("%d ", valor));

    }

}