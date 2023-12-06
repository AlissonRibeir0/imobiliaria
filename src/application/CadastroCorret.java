package application;
import java.util.Locale;
import java.util.Scanner;

public class CadastroCorret {

	public void cadCorret() {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o nome do corretor: ");
		String nome = sc.nextLine();
		
		System.out.println("Digite o CPF do corretor: ");
		String cpf = sc.nextLine();
		
		System.out.println(nome);
		System.out.println(cpf);	
		
	sc.close();	
	}
}
