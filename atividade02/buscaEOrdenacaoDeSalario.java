package atividade02;

import java.util.Scanner;

public class buscaEOrdenacaoDeSalario {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcao = 0;

        double vetSalariosOrdenados[];
        double vetSalariosNaoOrdenados[];
        String vetFuncionarios[];

        int quantidadeDeSalarios;
        double salario;
        String funcionario;

        System.out.println("Qual a quantidade de salários que serão cadastrados?");
        quantidadeDeSalarios = entrada.nextInt();

        vetSalariosOrdenados = new double[quantidadeDeSalarios];
        vetFuncionarios = new String[quantidadeDeSalarios];
        vetSalariosNaoOrdenados = new double[quantidadeDeSalarios];

        System.out.println("======= Escolha uma opção ======");
		System.out.println("0 - Sair");
		System.out.println("1 - Inserir Salários");
		System.out.print("Opção:\n> ");
		opcao = entrada.nextInt();

		// Tratar a opção caso não seja 0 ou 1
		while (opcao < 0 || opcao > 1) {
			System.out.println("Opção inválida, escolha uma das opções listadas.");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Salários");
			System.out.print("Opção:\n> ");
			opcao = entrada.nextInt();
		}
        while (opcao == 1) {
            for (int i = 0; i < quantidadeDeSalarios; i++) {
                System.out.println("Digite o salário do " + (i+1) + "º funcionário");
                salario = entrada.nextDouble();
                vetSalariosOrdenados[i] = salario;
                vetSalariosNaoOrdenados[i] = salario;

                System.out.println("Digite o nome do " + (i+1) + "º funcionário");
                funcionario = entrada.next();
                vetFuncionarios[i] = funcionario;
            }
            opcao = 0;
            break;
        }
        System.out.println("Cadastro de salários e funcionários efeutada.");

        // Ordenar os salarios com metodo da bolha
        double auxSalarioOrdenado;
        int contadorBolha = 0;

        for (int i = 0; i < quantidadeDeSalarios - 1; i++) {
            for (int j = 0; j < quantidadeDeSalarios - 1 - i; j ++) {
                if (vetSalariosOrdenados[j] > vetSalariosOrdenados[j + 1]) {
                    auxSalarioOrdenado = vetSalariosOrdenados[j];
                    vetSalariosOrdenados[j] = vetSalariosOrdenados[j+1];
                    vetSalariosOrdenados[j+1] = auxSalarioOrdenado;
                    contadorBolha++;
                }
            }
        }
        System.out.println("\nVetor ordenado de salarios pelo metodo da bolha");
        for (int listaBolha = 0; listaBolha < vetSalariosOrdenados.length; listaBolha ++) {
            System.out.println(vetSalariosOrdenados[listaBolha]);
        }

        // Ordenar os salários com o metodo da inserção direta
        int contadorInsercaoDireta = 0;
        int j;
        double temp;
        int i;

        for (i = 1; i < vetSalariosNaoOrdenados.length; i++) {
            temp = vetSalariosNaoOrdenados[i];
            j = i - 1;
            while ((j >= 0) && (vetSalariosNaoOrdenados[j] > temp)) {
                vetSalariosNaoOrdenados[j + 1] = vetSalariosNaoOrdenados[j--];
            }
            vetSalariosNaoOrdenados[j + 1] = temp;
            contadorInsercaoDireta++;
        }   
        System.out.println("\nVetor ordenado de salarios pelo metodo da bolha");
            for (int listaInsericaoDireta = 0; listaInsericaoDireta < vetSalariosOrdenados.length; listaInsericaoDireta ++) {
                System.out.println(vetSalariosNaoOrdenados[listaInsericaoDireta]);
            }
    
        System.out.println();
        System.out.println("A ordenação pelo metodo da bolha foi executada " + contadorBolha + " vezes para ordenar o vetor.");
        System.out.println("A ordenação pelo metodo da inserção direta foi executada " + contadorInsercaoDireta + " vezes para ordenar o vetor.");


        // Iniciar pesquisa
        int continuarPesquisa = 0;

        System.out.println("\nAgora vamos fazer as pesquisas.");
        System.out.println("0 - Digite 0 apenas na PESQUISA DO SALÁRIO para parar o programa");
        System.out.println("1 - Iniciar Pesquisa");
        System.out.print("Opção\n>");
        continuarPesquisa = entrada.nextInt();


    // tratamento da exceção
        while (opcao < 0 || opcao > 1) {
            System.out.println("\nOpção inválida, escolha uma das opções listadas.");
            System.out.println("0 - Digite 0 apenas na PESQUISA DO SALÁRIO para parar o programa");
            System.out.println("1 - Iniciar Pesquisa");
            System.out.print("Opção:\n> ");
            continuarPesquisa = entrada.nextInt();
        }

    while (continuarPesquisa == 1) {
        double pesquisaSalario;
              System.out.println();
              System.out.println("=== Digite 0 para sair do programa ===");
              System.out.print("Insira um salário para ser pesquisado\n>");
              pesquisaSalario = entrada.nextDouble();

        if (pesquisaSalario == 0) {
            continuarPesquisa = 0;
            System.out.println("Você decidiu sair do programa");
            break;
        }

        // Busca Sequêncial
        int contadorLinear = 0;
        int c = 0;

        while ((c < vetSalariosOrdenados.length)) {
            contadorLinear++;
            if (pesquisaSalario == vetSalariosOrdenados[c]) {
                break;
            }
            c++;
        }

        // Busca Binária
        int inicio = 0;
        int fim = vetSalariosOrdenados.length - 1;
        int meio = 0;
        int contadorBinario = 0;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (pesquisaSalario == vetSalariosOrdenados[meio]) {
                contadorBinario++;
                break;
            }else if (pesquisaSalario < vetSalariosOrdenados[meio]) {
                contadorBinario++;
                fim = meio - 1;
            }else {
                contadorBinario++;
                inicio = meio + 1;
            }
        }
        if (c == vetSalariosOrdenados.length) {
            System.out.println("Não achou o código pesquisado.");
        } else {
            System.out.println("Achou e está na posição " + (c+1));
            System.out.println("Pesquisou " + contadorLinear + " vez(es) como pesquisa linear para achar o código pesquisado.");
            System.out.println("Pesquisa " + contadorBinario + " vez(es) como pesquisa binária para achar o código pesquisado.");
        }
    }
    entrada.close();
    }
}
