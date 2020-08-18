package unidade1.arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Concat {

    public static ArrayList<Integer> concatNumerosPositivos(ArrayList<Integer> l1, ArrayList<Integer> l2) {
       // Escreva seu código aqui
       return null;
    }

    /* Não modifique este método */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
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
