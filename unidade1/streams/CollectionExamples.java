package unidade1.streams;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
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
         * A maneira mais simples de criar um map é invocar o método OF da interface
         * MAP. O método recebe nenhum ou qualquer número par de argumentos no formato
         * chave1, valor1, chave2, valor2, .... e retorna um map imutável
         */

        Map<String, String> emptyMap = Map.of();

        Map<String, String> friendPhones = Map.of("Bob", "+1-202-555-0118", "James", "+1-202-555-0220", "Katy",
                "+1-202-555-0175");

        /*
         * Agora vamos considerar algumas operações que podem ser aplicadas a maps
         * imutáveis usando o exemplo acima. O tamanho de um map é igual ao número de
         * pares que ele contém
         */
        System.out.println(emptyMap.size()); // 0
        System.out.println(friendPhones.size()); // 3

        /*
         * É possível obter um valor de um map a partir de sua chave O método
         * getOrDefault fornece uma maneira simples de prevenir exceções NullPointer,
         * uma vez que ele evita nulos.
         */
        String bobPhone = friendPhones.get("Bob"); // +1-202-555-0118
        String alicePhone = friendPhones.get("Alice"); // null
        String phone = friendPhones.getOrDefault("Alex", "Fone desconhecido"); // Fone desconhecido

        /*
         * Podemos acessar diretamente o conjunto de chaves e a coleção de valores de um
         * map
         */
        System.out.println(friendPhones.keySet()); // [James, Bob, Katy]
        System.out.println(friendPhones.values()); // [+1-202-555-0220, +1-202-555-0118, +1-202-555-0175]

        /****************** HASH MAP ****************/
        /*
         * A classe HashMap representa um map suportado por uma tabela hash. A função
         * hash dispersa os elementos apropriadamente dentro do map. O exemplo a seguir
         * demonstra um map de produtos onde a chave é o código do produto e o valor é o
         * nome
         */
        Map<Integer, String> products = new HashMap<>();

        products.put(1000, "Notebook");
        products.put(2000, "Phone");
        products.put(3000, "Keyboard");

        System.out.println(products); // {2000=Phone, 1000=Notebook, 3000=Keyboard}

        System.out.println(products.get(1000)); // Notebook

        products.remove(1000);

        System.out.println(products.get(1000)); // null

        products.putIfAbsent(3000, "Mouse"); // não altera o elemento atual

        System.out.println(products.get(3000)); // Keyboard

        /****************** LINKED HASH MAP ****************/
        /*
         * A classe LinkedHashMap armazena a ordem na qual os elementos foram inseridos.
         * Vamos ver uma parte do exemplo anterior novamente.
         */
        Map<Integer, String> products2 = new LinkedHashMap<>(); // map ordenado de produtos

        products2.put(1000, "Notebook");
        products2.put(2000, "Phone");
        products2.put(3000, "Keyboard");

        System.out.println(products2); // sempre ordenado {1000=Notebook, 2000=Phone, 3000=Keyboard}

        /****************** TREE MAP ****************/
        /*
         * A classe TreeMap representa um map onde é garantida a ordem dos elementos
         * Essa ordem corresponde à ordem das chaves, determinada por sua ordem natural
         * (se ela implementa a interface Comparable) ou por uma implementação
         * específica de Comparator. Esta classe implementa a interface SortedMap, que
         * estende a interface básica Map. ela fornece alguns novos métodos,
         * relacionados à comparação das chaves.
         */

        /*
         * O exemplo abaixo demonstra como criar e usar um objeto TreeMap. Este map é
         * preenchido com eventos, cada um dos quais tem uma data (key) e um titulo
         * (valor). LocalDate é uma classe que representa uma data. A invocação de
         * LocalDate.of(ano, mes, dia) cria um objeto que representa uma data com o ano,
         * mês e dia passados.
         */

        SortedMap<LocalDate, String> events = new TreeMap<>();

        events.put(LocalDate.of(2017, 6, 6), "The Java Conference");
        events.put(LocalDate.of(2017, 6, 7), "Another Java Conference");
        events.put(LocalDate.of(2017, 6, 8), "Discussion: career or education?");
        events.put(LocalDate.of(2017, 6, 9), "The modern art");
        events.put(LocalDate.of(2017, 6, 10), "Coffee master class");

        LocalDate fromInclusive = LocalDate.of(2017, 6, 8);
        LocalDate toExclusive = LocalDate.of(2017, 6, 10);

        /*
         * Este código imprime o submap resultante: {2017-06-08=Discussion: career or
         * education?, 2017-06-09=The modern art}
         */
        System.out.println(events.subMap(fromInclusive, toExclusive));

        /*
         * Use TreeMap somente quando você realmente precisa ordenar os elementos, pois
         * esta implementação é menos eficiente que HashMap.
         */

        /****************** ITERANDO POR UM MAP ****************/
        /*
         * O código a seguir mostra como obter chaves e valores em um loop FOR-EACH
         */

        Map<String, String> friendPhones2 = Map.of("Bob", "+1-202-555-0118", "James", "+1-202-555-0220", "Katy",
                "+1-202-555-0175");

        // imprimindo os nomes
        for (String name : friendPhones2.keySet()) {
            System.out.println(name);
        }

        // imprimindo os fones
        for (String ph : friendPhones2.values()) {
            System.out.println(ph);
        }

        /*
         * Se você quer imprimir uma chave e seu valor associado em uma mesma iteração,
         * você pode obter entrySet() e iterar por ela. Este código imprime todos os
         * pares como esperado. Bob: +1-202-555-0118 James: +1-202-555-0220 Katy:
         * +1-202-555-0175
         */

        for (var entry : friendPhones2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        /*
         * O mesmo comportamento pode ser obtido usando uma expressão lambda com dois
         * argumentos:
         */
        friendPhones2.forEach((nome, fone) -> System.out.println(nome + ": " + fone));

    }

}