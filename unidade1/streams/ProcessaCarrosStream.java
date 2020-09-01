package unidade1.streams;

import java.util.Arrays;
import java.util.List;

public class ProcessaCarrosStream {
    public static void main(String[] args) {
		Carro[] carros = { new Carro("Ford", "Corcel", 1985, 2000), new Carro("Ford", "Fiesta", 2015, 15000),
				new Carro("Ford", "Ranger", 2014, 75000), new Carro("Fiat", "Uno", 1999, 5000),
				new Carro("Fiat", "Palio", 2014, 10000), new Carro("Chevrolet", "Cobalt", 2017, 40000),
				new Carro("Chevrolet", "Onix", 2016, 30000), new Carro("Chevrolet", "Vectra", 2010, 23000),
				new Carro("Kia", "Sportage", 2014, 70000), new Carro("Toyota", "Corolla", 2018, 98000) };

		// obtém uma lista dos carros
		List<Carro> lista = Arrays.asList(carros);
}