package metodos;

import java.util.Scanner;

public class CalculadoraProcedural {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		int opcao = 0;
		menuDeEscolhas();
		opcao = ler.nextInt();

		while (opcao != 0) {
			double num1, num2;
			System.out.println("Digite o primeiro valor: ");
			num1 = ler.nextDouble();
			System.out.println("Digite o segundo valor: ");
			num2 = ler.nextDouble();
			switch (opcao) {
			case 1: 
				somarNumeros(num1, num2);
				// System.exit(0);
				break;
			case 2: 
				subtrairNumeros(num1, num2);
				// System.exit(0);
				break;
			case 3:
				multiplicarNumeros(num1, num2);
				// System.exit(0);
				break;
			case 4:
				dividirNumeros(num1, num2);
				// System.exit(0);
				break;
			default:
				System.out.println("Desculpe, não conseguimos fazer o calculo, pois, a opção não existe");
			}
			menuDeEscolhas();
			opcao = ler.nextInt();
		}
		ler.close();
	}
	
	static void somarNumeros (double a, double b) {
		double res;
		res = a + b;
		System.out.println("Resultado da Soma: " + res);
	}
	
	static void subtrairNumeros (double a, double b) {
		double res;
		res = a - b;
		System.out.println("Resultado da Subtração: " + res);
	}
	
	static void multiplicarNumeros (double a, double b) {
		double res;
		res = a * b;
		System.out.println("Resultado da Multiplicação: " + res);
	}
	
	static void dividirNumeros (double a, double b) {
		double res;
		res = a / b;
		System.out.println("Resultado da Divisão: " + res);
	}
	
	static void menuDeEscolhas() {	
		System.out.println("======= Escolha uma opção ======");
	    System.out.println("1 - Somar");
	    System.out.println("2 - Subtrair");
	    System.out.println("3 - Multiplicar");
	    System.out.println("4 - Dividir");
	    System.out.println("0 - Sair");
	    System.out.print("Opção:\n> ");
	}
}