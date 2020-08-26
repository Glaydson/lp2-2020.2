package unidade1.streams;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionExamples {

    public static void main(String[] args) {

        /****************** SET ****************/
        /*
         * SET - Coleção de elementos únicos. Diferente de List ou Array pois não é
         * possível obter um elemento pelo seu índice
         * 
         * Maneira mais simples de criar um set é pelo método OF da interface SET
         * Retorna um set imutável contendo todos os elementos passados ou um set vazio
         */
        Set<String> emptySet = Set.of();
        Set<String> persons = Set.of("Larry", "Kenny", "Sabrina");
        Set<Integer> numbers = Set.of(100, 200, 300, 400);

        /*
         * A ordem dos elementos de set imutáveis NÃO é fixa
         */

        System.out.println(emptySet); // []
        System.out.println(persons); // [Kenny, Larry, Sabrina] ou outra ordem
        System.out.println(numbers); // [400, 200, 300, 100] ou outra ordem

        /*
         * Uma das operações mais usadas em set é checar se um set contém ou não um
         * elemento. Para Sets imutáveis, somente é possível invocar CONTAINS, SIZE E
         * ISEMPTY
         */
        System.out.println(emptySet.contains("hello")); // false
        System.out.println(persons.contains("Sabrina")); // true
        System.out.println(persons.contains("John")); // false
        System.out.println(numbers.contains(300)); // true

        /****************** HASH SET ****************/
        /*
         * Um HashSet representa um set suportado por uma tabela hash. Usa códigos hash
         * dos elementos para armazená-los efetivamente. Não há garantias quanto a ordem
         * de iteração do set, e também não há garantia que essa ordem permaneça a mesma
         * ao longo do tempo O seguinte exemplo demonstra a criação de um HashSet e
         * adição de países a ele. Mesmo adicionando países duplicados, a saída não
         * conterá duplicidades
         */
        Set<String> countries = new HashSet<>();

        countries.add("India");
        countries.add("Japan");
        countries.add("Switzerland");
        countries.add("Japan");
        countries.add("Brazil");

        System.out.println(countries); // [Japan, Brazil, Switzerland, India]
        System.out.println(countries.contains("Switzerland")); // true

        /****************** TREE SET ****************/
        /*
         * A classe TreeSet representa um set onde é garantida a ordem dos elementos.
         * Essa ordem corresponde à ordem natural dos elementos adicionados. Para isso,
         * eles devem implementar a interface COMPARABLE, ou ter uma implementação
         * específica de COMPARATOR A ordem em que os elementos são ordenados é a mesma
         * que seria usada se fosse usado um algoritmo de ordenação
         * 
         * A classe TreeSet implementa a interface SortedSet, que estende a interface
         * Set. A interface SortedSet fornece alguns métodos relacionados à comparações
         * de elementos.
         * 
         */

        SortedSet<Integer> sortedSet = new TreeSet<>();

        sortedSet.add(10);
        sortedSet.add(15);
        sortedSet.add(13);
        sortedSet.add(21);
        sortedSet.add(17);

        System.out.println(sortedSet); // [10, 13, 15, 17, 21]
        System.out.println(sortedSet.headSet(15)); // [10, 13]

        System.out.println(sortedSet.first()); // minimum is 10
        System.out.println(sortedSet.last()); // maximum is 21

        /****************** LINKED HASH SET ****************/
        /*
         * A classe LinkedHashSet representa um set com elementos ligados. É diferente
         * do HashSet pois garante que a ordem dos elementos é a mesma ordem em que eles
         * foram inseridos no set. Reinserir um elemento que já está no LinkedHashSet
         * não muda essa ordem. LinkedHashSet é algo entre HashSet e TreeSet
         * 
         */

        Set<Character> characters = new LinkedHashSet<>();

        for (char c = 'a'; c <= 'k'; c++) {
            characters.add(c);
        }

        /*
         * Neste código, a ordem dos caracteres é sempre a mesma e bate com a ordem na
         * qual eles foram inseridos no set.
         */

        System.out.println(characters); // [a, b, c, d, e, f, g, h, i, j, k]

        /****************** OPERAÇÕES COM SETS ****************/
        /*
         * Primeiramente, vamos criar um set mutável. Então, aplicaremos operações a
         * ele, mudando os elementos.
         */

        // Obtendo um set mutável a partir de um imutável
        Set<String> countries2 = new HashSet<>(List.of("India", "Japan", "Switzerland"));

        countries2.addAll(List.of("India", "Germany", "Algeria"));
        System.out.println(countries2); // [Japan, Algeria, Switzerland, Germany, India]

        countries2.retainAll(List.of("Italy", "Japan", "India", "Germany"));
        System.out.println(countries2); // [Japan, Germany, India]

        countries2.removeAll(List.of("Japan", "Germany", "USA"));
        System.out.println(countries2); // [India]

        /****************** MAPS ****************/
        /*
         * Em algumas situações, é preciso armazenar pares de objetos associados. Por
         * exemplo, ao contar o número de palavras em um texto, o primeiro é uma palavra
         * e o segundo é o número de ocorrências no texto. Um MAP é um tipo de coleção
         * que armazena esse tipo de objetos. Um MAP é uma coleção de pares chave-valor.
         * Chaves são sempre únicas, e os valores podem se repetir.
         * 
         * A maneira mais simples de criar um map é invocar o método OF da interface MAP.
         * O método recebe nenhum ou qualquer número par de argumentos no formato chave1,
         * valor1, chave2, valor2, .... e retorna um map imutável
         */

        Map<String, String> emptyMap = Map.of();
        
        Map<String, String> friendPhones = Map.of(
                "Bob", "+1-202-555-0118",
                "James", "+1-202-555-0220",
                "Katy", "+1-202-555-0175"
        );
        

    }

}