package buscaepesquisalinear;

import java.util.Scanner;

public class cadastroEBuscaDeProdutos {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int vetCodigoProdutos[];
		String vetDescricaoProdutos[];
		double vetPrecoProdutos[];
		int qtdeProdutos = 0;

		int codigoProduto;
		String descricaoProduto;
		double precoProduto;
		
		int numeroDoCodigo;

		System.out.print("\nInforme a quantidade de produtos que serão cadastrados\n>");
		qtdeProdutos = entrada.nextInt();

		vetCodigoProdutos = new int[qtdeProdutos];
		vetPrecoProdutos = new double[qtdeProdutos];
		vetDescricaoProdutos = new String[qtdeProdutos];

		for (int i = 0; i < qtdeProdutos; i++) {
			System.out.print("\nInforme o código do " + (i+1) + "º produto\n>");
			codigoProduto = entrada.nextInt();
			vetCodigoProdutos[i] = codigoProduto;

			System.out.print("\nInforme a descrição do " + (i+1) + "º produto\n>");
			descricaoProduto = entrada.next();
			vetDescricaoProdutos[i] = descricaoProduto;

			System.out.print("\nInforme o preço do " + (i+1) + "º produto\n>R$");
			precoProduto = entrada.nextDouble();
			vetPrecoProdutos[i] = precoProduto;
		}

		System.out.println("Escolha um código\n>");
		numeroDoCodigo = entrada.nextInt();

		int i = 0;
		int contadorLinear = 0;
		while ((i < vetCodigoProdutos.length) && (numeroDoCodigo != vetCodigoProdutos[i])) {
			contadorLinear++;
			i++;
		}
		if (i == vetCodigoProdutos.length) {
			System.out.println("Não encontrou");
		}else {
			System.out.println("O nome do produto é : " + vetDescricaoProdutos[i]);
			System.out.println("O Preço do produto é : R$" + vetPrecoProdutos[i]);
		}
		int inicio = 0;
			int fim = vetCodigoProdutos.length - 1;
			int meio;
			int contadorBinario = 0;
			while (inicio <= fim) {
				meio = (inicio + fim) / 2;
				if (numeroDoCodigo == vetCodigoProdutos[meio]){
					contadorBinario++;
					break;
				}

				if (numeroDoCodigo < vetCodigoProdutos[meio]){
					contadorBinario++;
					fim = meio - 1;
				}
				else{
					contadorBinario++;
					inicio = meio + 1;
				}
			}
			System.out.println("Caminhou no vetor como pesquisa linear " + contadorLinear + " vezes.");
			System.out.println("Caminhou no vetor como pesquisa binária " + contadorBinario + " vezes.");
			entrada.close();
	}
}
