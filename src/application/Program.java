package application;

import java.util.Locale;
import java.util.Scanner;

import util.Style;

public class Program {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Style.linha(Style.MAX);
		System.out.println("                                                _");
		System.out.println("    ____  __  __  ___  ___  ____  _    ____   /_ /  ____   ____   ___");
		System.out.println("   |_  _||  \\/  || _ || _ \\|_  _|| |  |_  _|  ___  |  _ \\ |_  _| / _ \\");
		System.out.println("     ||  | |\\/| ||| ||||_)/  ||  | |    ||   / _ \\ | |_)/   ||  | /_\\ |");
		System.out.println("    _||_ | |  | |||_||||_)\\ _||_ | |_  _||_ | /_\\ || |\\ \\  _||_ |  _  |");
		System.out.println("   |____||_|  |_||___||___/|____||___||____||_| |_||_| \\_\\|____||_| |_|");
		System.out.println();
		System.out.println();

		int selectOption;
		do {
			Style.linha(Style.MAX);
			Style.styleLine(33);
			System.out.print("MENU PRINCIPAL");
			Style.styleLine(33);
			System.out.println();
			
			System.out.println("***OPÇÕES***");
			System.out.println();
			System.out.println("[1]CADASTRO DE IMÓVEIS");
			System.out.println("[2]CADASTRO DE CLIENTES/INTERESSADOS");
			System.out.println("[3]CADASTRO DE CORRETORES");
			System.out.println("[4]CADASTRO DE PROPOSTAS DE COMPRA/ALUGUEL");
			System.out.println("[5]SIMULAÇÃO DE FINANCIAMENTO");
			System.out.println("[0]ENCERRAR SESSÃO");
			Style.linha(Style.MAX);

			System.out.println("Selecione a opção desejada: ");
			selectOption = sc.nextInt();
			sc.nextLine();
			
			switch (selectOption) {
			case 1:
				CadastroImoveis cadastroImoveis = new CadastroImoveis(); // "apelido" de nome cadastroImoveis
				cadastroImoveis.realizarCadastro(); // método de nome realizarCadastro()
				break;
			case 2:
				CadastroClientes cadastroClientes = new CadastroClientes();
				cadastroClientes.cadClientes();
				break;
			case 3:
				CadastroCorret cadastroCorret = new CadastroCorret();
				cadastroCorret.cadCorret();
				break;
			case 4:
				CadastroProposta cadProposta = new CadastroProposta();
				cadProposta.realizarProp();
				break;
			case 5:
				SimulacaoFinan simulacaoFin = new SimulacaoFinan();
				simulacaoFin.realizarSimu();
				break;
			case 0:
				// sai do loop
				break;
			default:
				System.out.println("inválido");
				try {
					Thread.sleep(1000); // Pausa por 1 segundo
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}

		} while (selectOption != 0);

		Style.linha(Style.MAX);
		System.out.println("FIM");
	}
}
