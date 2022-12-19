package arrayslistas_application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramLists {

	public static void main(String[] args) {
		// List: um tipo de grafo onde cada componente é um nodo que aponta para o proximo.
		// List é uma interface, não se instancia. É preciso criar classe que "implemente" a interface
		// ArrayList: uma classe que implementa a interface List. Une vantagens de array fixo e dinâmico
		// <> = Generics: Mecanismo que permite passar o tipo de variável como um parâmetro.
		//		Parametrização do Tipo de Variável
		
		List<String> list = new ArrayList<>();
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");
		list.add("John");
		list.add("Joseph");
		
		System.out.println(list.size());
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println("------------------");
		
		System.out.println("Insert 'Marco' at position 2:");
		list.add(2,"Marco");
		System.out.println(list.size());
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println("------------------");
		
		// Obs: este "Anna" é uma "nova instância" da WrapperClass String.
		// Nada a ver com a "Anna" de list.add("Anna") acima
		System.out.println("Remove 'Anna':");
 		list.remove("Anna");
 		System.out.println(list.size());
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println("------------------");
		
		System.out.println("Remove element at position 1:");
		list.remove(1);
		System.out.println(list.size());
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println("------------------");
		
		// Mostra a posicao de 'Marco'
		System.out.println("Position of name 'Marco': " + list.indexOf("Marco"));
		System.out.println("------------------");
		
		// Filtra todos nomes que começam com 'J'
		// Precisa criar uma nova "List"
		// list.stream(); um Tipo de Dado especial do Java 8 que aceita expressões Lambda
		// filter(): recebe um predicado.
		//		Retorna um dado do tipo Stream não compatível com List
		// collect(Collectors.toList()). Converte o Stream retornado para List novamente
		List<String> filtered = list.stream().filter(name -> name.charAt(0) == 'J').collect(Collectors.toList());
		System.out.println("Filter every name which starts with 'J'");
		for (String name : filtered) {
			System.out.println(name);
		}
		System.out.println("------------------");
		
		
		// Obs: name -> name.charAt(0) == 'M' é uma Função Lambda
		System.out.println("Remove every name which starts with letter 'M':");
		list.removeIf(name -> name.charAt(0) == 'M');
		System.out.println(list.size());
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println("------------------");
		
		// Mostra a posicao de 'Marco', que foi excluído. Será -1
		System.out.println("Position of name 'Marco': " + list.indexOf("Marco"));
		System.out.println("------------------");
		
		//Busca o primeiro nome que começa com 'B' ou retorna null.
		System.out.println("Return first name which starts with 'B'");
		String nameSearch = list.stream().filter(name -> name.charAt(0) == 'B').findFirst().orElse(null);
		System.out.println("Returned name: "+nameSearch);
		System.out.println("------------------");
		
		//Busca o primeiro nome que começa com 'W' ou retorna null.
		System.out.println("Return first name which starts with 'W'");
		nameSearch = list.stream().filter(name -> name.charAt(0) == 'W').findFirst().orElse(null);
		System.out.println("Returned name: "+nameSearch);
	}

}
