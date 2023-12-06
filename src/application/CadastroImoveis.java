package application;
import java.util.Locale;
import java.util.Scanner;

public class CadastroImoveis {
	
	public void realizarCadastro() {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		char continuar;
		do {
			System.out.println("===========================================================================");
			System.out.println("ENDEREÇO:");
			System.out.println();
			
			System.out.print("Rua: ");
			String rua = sc.nextLine();
			
			System.out.print("Bairro: ");
			String bairro = sc.nextLine();
			
			System.out.print("Cidade: ");
			String cidade = sc.nextLine();
			
			System.out.print("Estado/UF: ");
			String estadoUf = sc.nextLine();
			System.out.println();
			
			System.out.println("===========================================================================");
			System.out.println();
			
			System.out.println("DADOS DO ENDEREÇO: ");
			System.out.println();
			System.out.println("Rua: " + rua);
			System.out.println("Bairro: " + bairro);
			System.out.println("Cidade: " + cidade);
			System.out.println("Estado/UF: " + estadoUf);
			System.out.println();
			
			System.out.println("As informações estão corretas? ");
			System.out.print("'S' para sim e 'N' para não: ");
			continuar = sc.next().charAt(0);
			
		}while(continuar == 'n');
		
		sc.close();
		
	}

}
