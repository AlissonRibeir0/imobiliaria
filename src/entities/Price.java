package entities;
import java.util.Locale;

import application.Program;
import util.Style;


public class Price {
	
	@SuppressWarnings("unused")  //Oculta mensagens de variáveis não usadas

	public void cadPrice() {

		double vlImovel, vlEntrada, valorFinanciado, taxaJuros, vlParcelasPorMes, amort, vlPorcInicial;
		double totalJuros = 0, totalAmort = 0;
		int numParcelas;
		int iniciar ,tabDet;

		Locale.setDefault(Locale.US);
		//Scanner sc = new Scanner(System.in);

		do {
			Style.linha(Style.MAX);
			System.out.printf("Deseja fazer uma nova simulação de financiamento no modelo Price?%n%n[1]SIM%n[0]NAO%n%n");
			iniciar = Program.sc.nextInt();
			Program.sc.nextLine();

			if (iniciar != 1 && iniciar != 0) {
				System.out.printf("Opção incorreta! Digite 's' para SIM e 'n' para NÃO%n%n");
			} else {
				if (iniciar == 1) {
					Style.linha(Style.MAX);
					Style.styleLine(34);
					System.out.print("TABELA PRICE");
					Style.styleLine(34);
					System.out.println();
					System.out.println();

					System.out.print("Digite o valor do imóvel: R$");
					vlImovel = Program.sc.nextDouble();

					System.out.print("Digite o valor de entrada: R$");
					vlEntrada = Program.sc.nextDouble();
					System.out.println();

					valorFinanciado = vlImovel - vlEntrada;
					System.out.printf("Valor a ser financiado: R$ %.2f%n", valorFinanciado);

					System.out.print("Digite a taxa de juros(%%): ");
					taxaJuros = Program.sc.nextDouble();

					System.out.print("Digite o número de parcelas: ");
					numParcelas = Program.sc.nextInt();
					Program.sc.nextLine();

					System.out.println();

					vlParcelasPorMes = calculoPrice(valorFinanciado, taxaJuros, numParcelas);

					Style.linha(Style.MAX);
					System.out.printf("Valor do financiamento:R$ %.2f reais.%n", valorFinanciado);
					System.out.printf("Valor fixo das parcelas: R$ %.2f reais.%n", vlParcelasPorMes);
					System.out.printf("Números de parcelas: %d vezes%n", numParcelas);
					System.out.printf("Taxa de juros(%%): %.2f%% a.m.%n%n", taxaJuros);

					System.out.printf("Valor fixo das parcelas: R$ %.2f reais.%n", vlParcelasPorMes);

					vlPorcInicial = valorFinanciado * (taxaJuros / 100);

					amort = vlParcelasPorMes - vlPorcInicial;

					System.out.printf("Valor do juros no primeiro mês: R$ %.2f reais.%n", vlPorcInicial);
					System.out.printf("Valor da amortização no primeiro mês: R$ %.2f reais.%n%n", amort);

					do {
						Style.styleLine(33);
						System.out.print("DETALHES - SAC");
						Style.styleLine(33);
						System.out.println();
						System.out.println();

						System.out.printf("Deseja ver tabela detalhada?%n%n[1]SIM%n[0]NÃO%n%n");
						tabDet = Program.sc.nextInt();
						Program.sc.nextLine();

						if (tabDet != 1 && tabDet != 0) {
							System.out.printf("Opção incorreta! Digite '1' para SIM e '0' para NÃO%n%n");
						} else {
							if (tabDet == 1) {
								Style.linha(Style.MAX);

								Style.styleLine(25);
								System.out.print("DETALHES DE SIMULAÇÃO - PRICE");
								Style.styleLine(26);
								System.out.println();
								System.out.println();

								System.out.printf("Valor do financiamento:R$ %.2f reais.%n", valorFinanciado);
								System.out.printf("Valor fixo das parcelas: R$ %.2f reais.%n", vlParcelasPorMes);
								System.out.printf("Números de parcelas: %d vezes%n", numParcelas);
								System.out.printf("Taxa de juros(%%): %.2f%% a.m.%n%n", taxaJuros);

								Style.styleLine(28);
								System.out.print("TABELA DETALHADA - PRICE");
								Style.styleLine(28);
								System.out.println();
								System.out.println();

								System.out.printf("Valor fixo das parcelas: R$ %.2f reais.%n", vlParcelasPorMes);

								vlPorcInicial = valorFinanciado * (taxaJuros / 100);

								amort = vlParcelasPorMes - vlPorcInicial;

								System.out.printf("Valor do juros no primeiro mês: R$ %.2f reais.%n", vlPorcInicial);
								System.out.printf("Valor da amortização no primeiro mês: R$ %.2f reais.%n%n", amort);

								for (int i = 2; i <= numParcelas; i++) {
									valorFinanciado -= amort;
									vlPorcInicial = valorFinanciado * (taxaJuros / 100);
									amort = vlParcelasPorMes - vlPorcInicial;
									totalJuros += vlPorcInicial;
									totalAmort += amort;

									System.out.printf("%d%c mes - Parcela fixa de R$ %.2f reais%n", i, 248,vlParcelasPorMes);

									if (valorFinanciado < 0 && vlPorcInicial < 0) {
										System.out.printf("Valor atualizado da amortização: R$ %.2f reais%n", amort);
										System.out.printf("Valor atualizado do juros: SEM JUROS.%n");
										System.out.printf("Valor atualizado do saldo devedor: R$ %.2f reais%n%n",valorFinanciado);

									} else {
										System.out.printf("Valor atualizado da amortização: R$ %.2f reais%n", amort);
										System.out.printf("Valor atualizado do juros: R$ %.2f reais%n", vlPorcInicial);
										System.out.printf("Saldo devedor: R$ %.2f reais%n%n", valorFinanciado);
									}
								}
								break;

							}
						}

					} while (tabDet != 0);
				}
			}

		} while (iniciar != 0);
	}

	public double calculoPrice(double vlFinanc, double txJuros, int nParc) {
		return vlFinanc / (((Math.pow(1.0 + (txJuros / 100), nParc)) - 1.0)
				/ ((Math.pow(1.0 + (txJuros / 100), nParc)) * (txJuros / 100)));
	}

}
