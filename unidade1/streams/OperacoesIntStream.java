package unidade1.streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OperacoesIntStream {

    public static void main(String[] args) {
        int[] valores = {2, 10, 6, 1, 4, 50, 60, 7, 0, 9, 15, 38};

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
        System.out.printf("Soma: %d%n", IntStream.of(valores).sum());
        System.out.printf("Média: %.2f%n", IntStream.of(valores).average().getAsDouble());

    }

    
}