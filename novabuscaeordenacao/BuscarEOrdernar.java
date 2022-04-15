package novabuscaeordenacao;

import java.util.Scanner;

public class BuscarEOrdernar {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int opcao = 0;

		// Vetores para guardar os codigos, pre�os e descri��es dos produtos.
		int vetCodigos[];
		double vetPrecos[];
		String vetDescricoes[];

		// variaveis para fazer pergunta
		int quantidadeDeProdutos;
		int codigoDoProduto;
		double precoDoProduto;
		String descricaoDoProduto;

		System.out.print("Qual a quantidade de produtos que serão cadastrados?\n>");
		quantidadeDeProdutos = entrada.nextInt();

		vetCodigos = new int[quantidadeDeProdutos];
		vetPrecos = new double[quantidadeDeProdutos];
		vetDescricoes = new String[quantidadeDeProdutos];
		
		System.out.println("======= Escolha uma opção ======");
		System.out.println("0 - Sair");
		System.out.println("1 - Inserir Produtos");
		System.out.print("Opção:\n> ");
		opcao = entrada.nextInt();

		// Tratar a opção caso não seja 0 ou 1
		while (opcao < 0 || opcao > 1) {
			System.out.println("Opção inválida, escolha uma das opções listadas.");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Produtos");
			System.out.print("Opção:\n> ");
			opcao = entrada.nextInt();
		}
		while (opcao == 1 ) {
			for (int i = 0; i < quantidadeDeProdutos; i ++) {
				System.out.print("Insira o código do " + (i+1) + "º produto\n>");
				codigoDoProduto = entrada.nextInt();
				vetCodigos[i] = codigoDoProduto;

				System.out.print("Insira o preço do " + (i+1) + "º produto\n>");
				precoDoProduto = entrada.nextDouble();
				vetPrecos[i] = precoDoProduto;

				System.out.print("Insira o nome do " + (i+1) + "º produto\n>");
				descricaoDoProduto = entrada.next();
				vetDescricoes[i] = descricaoDoProduto;
			}
			opcao = 0;
			break;
		}
		System.out.println("Cadastro de produtos realizado.");			

		// Ordernar os vetores
		double auxPreco;
		int auxCodigo;

		// Ordenar os Códigos
		for (int i = 0; i < quantidadeDeProdutos - 1; i++) {
			for (int j = 0; j < quantidadeDeProdutos - 1 - i; j++) {
				if (vetCodigos[j] > vetCodigos[j+1]) {
					auxCodigo = vetCodigos[j];
					vetCodigos[j] = vetCodigos[j+1];
					vetCodigos[j+1] = auxCodigo;
				}
			}
		}
		
		// Ordenar os preços
		for (int i = 0; i < quantidadeDeProdutos - 1; i++) {
			for (int j = 0; j < quantidadeDeProdutos - 1 - i; j++) {
				if (vetPrecos[j] > vetPrecos[j+1]) {
					auxPreco = vetPrecos[j];
					vetPrecos[j] = vetPrecos[j+1];
					vetPrecos[j+1] = auxPreco;
				}
			}
		}

		//Mostrando a lista de códigos ordenada
		System.out.println("O vetor de códigos ordenado é: ");
		for (int i = 0; i < quantidadeDeProdutos; i++) {
			System.out.println(vetCodigos[i]);
		}

		// Mostrando a lista de preços ordenada
		System.out.println("O vetor de preços ordenado é: ");
		for (int i = 0; i < quantidadeDeProdutos; i++) {
			System.out.println("R$" + vetPrecos[i]);
		}

		// Mostrando a lista dos nomes do produtos
		System.out.println("O vetor de produtos é: ");
		for (int i = 0; i < quantidadeDeProdutos; i++) {
			System.out.println(vetDescricoes[i]);
		}
		
		// Iniciando pesquisa
		int continuarPesquisa = 0;
		System.out.println("Agora vamos fazer as pesquisas.");
		System.out.println("0 - Parar o programa");
		System.out.println("1 - Iniciar Pesquisa");
		System.out.print("Opção\n>");
		continuarPesquisa = entrada.nextInt();
		while (opcao < 0 || opcao > 1) {
			System.out.println("Opção inválida, escolha uma das opções listadas.");
			System.out.println("0 - Parar o programa");
			System.out.println("1 - Iniciar Pesquisa");
			System.out.print("Opção:\n> ");
			continuarPesquisa = entrada.nextInt();
		}
		while (continuarPesquisa == 1) {
			int pesquisaCodigo;
			System.out.println();
			System.out.println("=== Digite 0 para sair do programa ===");
			System.out.print("Insira um código para ser pesquisado\n>");
			pesquisaCodigo = entrada.nextInt();
			
			if (pesquisaCodigo == 0) {
				continuarPesquisa = 0;
				System.out.println("Você decidiu sair do programa.");
				break;
			}
			
			// Busca linear
			int c = 0;
			int contadorLinear = 0;
			while ((c < vetCodigos.length)) {
				contadorLinear++;
				if (pesquisaCodigo == vetCodigos[c]) {
					break;
				}
				c++;
			}

			// Busca Binária
			int inicio = 0;
			int fim = vetCodigos.length - 1;
			int meio;
			int contadorBinario = 0;
			while (inicio <= fim) {
				meio = (inicio + fim) / 2;
				if (pesquisaCodigo == vetCodigos[meio]) {
					contadorBinario++;
					break;
				}
				if (pesquisaCodigo < vetCodigos[meio]) {
					contadorBinario++;
					fim = meio - 1;	
				}else {
					contadorBinario++;
					inicio = meio + 1;
				}
			}
			if (c == vetCodigos.length) {
				System.out.println("Não achou o código pesquisado");
			} else {
				System.out.println("\n\nAchou e está na posição " + c);
				System.out.println("Pesquisou " + contadorLinear + " veze(s) como pesquisa linear para achar o código pesquisado");
				System.out.println("Pesquisou " + contadorBinario + " veze(s) como pesquisa binária para achar o código pesquisado");
			}
		}
		entrada.close();
	}
}
