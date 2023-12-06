package application;

import java.util.Locale;

import entities.Price;
import entities.Sac;
import util.Style;

public class SimulacaoFinan {

	public void realizarSimu() {

		Locale.setDefault(Locale.US);

		try {
			Thread.sleep(1000); // Pausa por 1 segundo
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int op;
		
		do {
			Style.linha(Style.MAX);
			Style.styleLine(27);
			System.out.print("SIMULAÇÃO DE FINANCIAMENTO");
			Style.styleLine(27);
			System.out.println();
			System.out.println("[1]Tabela SAC");
			System.out.println("[2]Tabela PRICE");
			System.out.println("[0]Retornar");

			op = Program.sc.nextInt();

			switch (op) {
			case 1:
				Sac tabSac = new Sac();
				tabSac.cadSac();
				break;
			case 2:
				Price tabPrice = new Price();
				tabPrice.cadPrice();
				break;
			case 0:
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
		} while (op != 0);

	}

}
