package unidade1.streams;

import java.util.ArrayList;
import java.util.List;

public class ContaPalavras {

    public static void main(String[] args) {
        List<String> dataSource = new ArrayList<>();

        dataSource.add("isto");
        dataSource.add("é");
        dataSource.add("um");
        dataSource.add("teste");
        dataSource.add("é");
        dataSource.add("somente");
        dataSource.add("um");
        dataSource.add("teste");
        dataSource.add("e");
        dataSource.add("nada");
        dataSource.add("mais");

        long contador = dataSource.stream()  // converte o arraylist para stream
                            .distinct()     // elimina as palavras repetidas
                            .filter(palavra -> palavra.length() >= 5)    // elimina as palavras < 4 caracteres
                            .count();   // retorna a quantidade de palavras - operação terminal

        System.out.println(
            String.format("A Coleção possui %d palavras distintas de 5 ou mais caracteres.", contador));

    }

}