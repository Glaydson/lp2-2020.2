package unidade1.streams;

import java.util.stream.DoubleStream;

public class OperacoesDoubleStream {

    public static void main(String[] args) {
        // Array original
        double[] notas = { 4.8, 5.5, 10.0, 8.2, 1.5, 4.5, 7.5, 8.0, 5.2, 6.0 };

        /*
         * A média das notas 
         * A maior e menor notas 
         * A quantidade de notas maiores ou iguais a 5.0 
         * A lista de notas abaixo de 5.0 em ordem crescente
         */

         //Média
         System.out.printf("Média: %.2f%n", DoubleStream.of(notas).average().getAsDouble());
        
         // Maior e menor
         System.out.printf("Menor Nota: %.2f%n", DoubleStream.of(notas).min().getAsDouble());
         System.out.printf("Maior Nota: %.2f%n", DoubleStream.of(notas).max().getAsDouble());

         // Quantidade de notas maiores ou iguais a 5
         System.out.printf("Quantidade de notas maiores ou iguais a 5: %d%n", 
                DoubleStream.of(notas)
                            .filter(n -> n >= 5)
                            .count());

         // Lista de notas abaixo de 5 em ordem crescente
         System.out.print("Notas menores que 5: ");
         DoubleStream.of(notas)
            .filter(n -> n < 5)
            .sorted()
            .forEach(n -> System.out.printf("%.2f ", n));

    }

}