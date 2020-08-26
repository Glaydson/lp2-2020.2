package unidade1.generics;


/**

Classe Caixa, baseada em Object, requerendo o cast toda vez que se desejar obter algum conteúdo específico, como por exemplo:

    Caixa<Bolo> caixaBolo = new Caixa<>();
    caixaBolo.put(new Bolo());
    // Sem o cast, somente o objeto Bolo pode ser retirado da caixa
    Bolo bolo = caixaBolo.get();

Casting não é desejável e pode falhar em tempo de execução. Construa uma solução mais genérica…

*/


public class Caixa<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }

}