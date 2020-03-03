package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.employees;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US); 
		Scanner sc = new Scanner(System.in);  
		
		int n = 0; 
		//int id = 0;
		double percentualAumento;
		
		List<employees> list = new ArrayList<>(); 

		
		System.out.println("Programa para criar uma lista para uma determinada qtd de empregados.");
		System.out.println("Pergunta quantidade, ID, Name e Salario. Pede um ID e valor de aumento");
		System.out.println("para o funcionario e por fim mostra as informações atualizadas. ");
		System.out.println();
		System.out.print("Quantos empregados serão registrados? ");
		n = sc.nextInt();

		for (int i=1; i<=n; i++) { 
 			System.out.println(); 
 			System.out.println("Empregado #" + i + ": "); 
 			System.out.print("Id: "); 
 			int id = sc.nextInt(); 
 			System.out.print("Nome: "); 
 			sc.nextLine(); 
 			String name = sc.nextLine(); 
 			System.out.print("Salário: "); 
 			double salary = sc.nextDouble(); 
 			list.add(new employees(id, name, salary)); 
 		} 

		System.out.println(); 
		System.out.println("Entre com o ID do funcioário que irá receber aumento: "); 
		int id = sc.nextInt();
		
		
		employees emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); 
 		if (emp == null) { 
 			System.out.println("Este ID não existe!"); 
 		} 
 		else { 
 			System.out.println("Entre com o percentual de aumento: "); 
 			percentualAumento = sc.nextDouble();
 			emp.increaseSalary(percentualAumento); 
 		} 
 		 
 		// PART 3 - LISTING EMPLOYEES: 
 		 
 		System.out.println(); 
 		System.out.println("Lista de Empregados:"); 
 		for (employees obj : list) { 
 			System.out.println(obj); 
 		} 
 				 
 		sc.close();  

		
	}

}
