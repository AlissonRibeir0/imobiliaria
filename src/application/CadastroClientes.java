package application;

import java.util.Locale;

import entities.Cliente;
import util.Style;

public class CadastroClientes {

	public void cadClientes() {

		Locale.setDefault(Locale.US);
		
		Cliente x;

		char continuar;
		do {
			System.out.println();
			Style.linha(Style.MAX);
			Style.styleLine(23);
			System.out.print("CADASTRO DE CLIENTES/INTERESSADOS");
			Style.styleLine(24);
			System.out.println();
			
			System.out.println("***DADOS PESSOAIS***");

			System.out.println();
			System.out.print("Nome: ");
			String nome = Program.sc.nextLine();

			System.out.print("Idade: ");
		    int idade = Program.sc.nextInt();
			Program.sc.nextLine();

			System.out.print("CPF: ");
			String cPF = Program.sc.nextLine();
			System.out.println();
			
			x = new Cliente(nome, cPF, idade);

			Style.linha(Style.MAX);
			System.out.println(x);

			System.out.println();
			System.out.println("As informações estão corretas? ");
			System.out.print("'S' para sim e 'N' para não: ");
			continuar = Program.sc.next().charAt(0);
			Program.sc.nextLine();

		} while (continuar == 'n');
	}

}
