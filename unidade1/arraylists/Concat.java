package unidade1.arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Concat {

    public static ArrayList<Integer> concatNumerosPositivos(ArrayList<Integer> l1, ArrayList<Integer> l2) {
       // Escreva seu código aqui
       ArrayList<Integer> resultado = new ArrayList<>();
       // Percorrer o primeiro array, obter os numeros positivos e adicionar em resultado
       for (Integer x: l1) {
           if (x > 0) resultado.add(x);
       }
       for (Integer x: l2) {
        if (x > 0) resultado.add(x);
       }
       return resultado;
    }

    /* Não modifique este método */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre o primeiro array:");
        ArrayList<Integer> list1 = readArrayList(scanner);
        System.out.println("Entre o segundo array:");
        ArrayList<Integer> list2 = readArrayList(scanner);

        ArrayList<Integer> result = concatNumerosPositivos(list1, list2);

        result.forEach(n -> System.out.print(n + " "));
    }

    /* Não modifique este método */
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
