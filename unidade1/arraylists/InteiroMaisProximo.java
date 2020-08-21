package unidade1.arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InteiroMaisProximo {
    public static void main(String[] args) {
        // Escreva seu código aqui
        Scanner scanner = new Scanner(System.in);
        // Ler o array de números
        System.out.println("Entre com o array de números:");
        ArrayList<Integer> array = readArrayList(scanner);
        // Ler o número N
        System.out.println("Entre com o número N:");
        int n = scanner.nextInt();

        Collections.sort(array);
        int distancia = Integer.MAX_VALUE;

        // Obter a menor distância entre N e os elementos do array
        for (Integer x: array) {
            if (Math.abs(x - n) < distancia ) {
                distancia = Math.abs(x - n);
            }
        }

        ArrayList<Integer> saida = new ArrayList<>();
        // Percorrer novamente o array e obter os números do array que
        // sejam mais próximos de N
        for (Integer x: array) {
            if (Math.abs(x - n) == distancia ) {
                saida.add(x);
            }
        }

        // Imprimir o array de saída
        for (Integer x: saida) {
            System.out.print(x + " ");
        }

       
    }

    // Não modifique este método
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}