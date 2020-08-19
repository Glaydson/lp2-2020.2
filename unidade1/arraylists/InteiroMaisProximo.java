package unidade1.arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InteiroMaisProximo {
    public static void main(String[] args) {
        // Escreva seu código aqui
        Scanner scanner = new Scanner(System.in);
        // Ler o array de números
        ArrayList<Integer> array = readArrayList(scanner);
        // Ler o número N
        int n = scanner.nextInt();
       
    }

    // Não modifique este método
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}