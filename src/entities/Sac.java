package entities;

import java.util.Locale;

import application.Program;
import util.Style;

public class Sac {

	double vlImovel, vlEntrada, vlFinanciado, txJuros, saldoDev = 0, vlParcelasPorMes, amort, juros, vlParcela,
			jurosAtual, totalJuros = 0, totalAmort = 0;
	int nParcelas, iniciar, tabDet;
	
	public void cadSac() {
		
		int iniciar, tabDet;

		Locale.setDefault(Locale.US);
		
		do {
			Style.linha(Style.MAX);

			Style.styleLine(35);
			System.out.print("TABELA SAC");
			Style.styleLine(35);
			System.out.println();
			System.out.println();

			System.out.println("Deseja fazer uma nova simulação de financiamento no modelo SAC?");
			System.out.println("[1]SIM");
			System.out.println("[0]NAO");
			iniciar = Program.sc.nextInt();

			if (iniciar != 1 && iniciar != 0) {
				System.out.println("Opção incorreta! Digite '1' para SIM e '0' para NÃO");
			} else {
				if (iniciar == 1) {
					Style.linha(Style.MAX);

					Style.styleLine(35);
					System.out.print("TABELA SAC");
					Style.styleLine(35);
					System.out.println();
					System.out.println();

					System.out.print("Digite o valor do imóvel: R$");
					vlImovel = Program.sc.nextDouble();

					System.out.print("Digite o valor de entrada: R$");
					vlEntrada = Program.sc.nextDouble();
					System.out.println();

					vlFinanciado = vlImovel - vlEntrada;
					System.out.printf("Valor a ser financiado: R$ %.2f%n", vlFinanciado);

					System.out.print("Digite a taxa de juros(%%): ");
					txJuros = Program.sc.nextDouble();

					System.out.print("Digite o número de parcelas: ");
					nParcelas = Program.sc.nextInt();
					Program.sc.nextLine();

					System.out.println();

					Style.linha(Style.MAX);
					System.out.printf("Valor do financiamento:R$ %.2f reais.%n", vlFinanciado);
					System.out.printf("Números de parcelas: %d vezes%n", nParcelas);
					System.out.printf("Taxa de juros(%%): %.2f%% a.m.%n%n", txJuros);

					amort = vlFinanciado / nParcelas;
					saldoDev += vlFinanciado;
					juros = saldoDev * (txJuros / 100);
					vlParcela = juros + amort;

					System.out.printf("Valor da parcela no primeiro mês: R$ %.2f reais.%n", vlParcela);
					System.out.printf("Valor do juros no primeiro mês: R$ %.2f reais.%n", juros);
					System.out.printf("Valor fixo de amortização mensal: R$ %.2f reais.%n%n", amort);

					do {
						Style.styleLine(33);
						System.out.print("DETALHES - SAC");
						Style.styleLine(33);
						System.out.println();
						System.out.println();

						System.out.println("Deseja ver tabela detalhada?");
						System.out.println("[1]SIM");
						System.out.println("[0]NÃO");
						tabDet = Program.sc.nextInt();

						if (tabDet != 1 && tabDet != 0) {
							System.out.println("Opção incorreta! Digite '1' para SIM e '0' para NÃO");
						} else {
							if (tabDet == 1) {
								Style.linha(Style.MAX);

								Style.styleLine(26);
								System.out.print("DETALHES DE SIMULAÇÃO - SAC");
								Style.styleLine(27);
								System.out.println();
								System.out.println();

								System.out.printf("Valor do financiamento:R$ %.2f reais.%n", vlFinanciado);
								System.out.printf("Números de parcelas: %d vezes%n", nParcelas);
								System.out.printf("Taxa de juros: %.2f%% a.m.%n%n", txJuros);

								Style.styleLine(29);
								System.out.print("TABELA DETALHADA - SAC");
								Style.styleLine(29);
								System.out.println();
								System.out.println();

								System.out.printf("Valor da parcela no primeiro mês: R$ %.2f reais.%n", vlParcela);
								System.out.printf("Valor do juros no primeiro mês: R$ %.2f reais.%n", juros);
								System.out.printf("Valor fixo de amortização mensal: R$ %.2f reais.%n%n", amort);

								for (int i = 2; i <= nParcelas; i++) {
									double pmt;

									saldoDev -= amort;
									jurosAtual = saldoDev * (txJuros / 100);
									pmt = jurosAtual + amort;

									if (saldoDev < 0 && jurosAtual < 0) {
										System.out.printf("%d%c mes - Valor da Parcela: R$ %.2f reais%n", i, 248, pmt);
										System.out.printf("Valor fixo mensal de amortização: R$ %.2f reais%n", amort);
										System.out.println("Valor atualizado do juros: SEM JUROS.");
										System.out.printf("Valor atualizado do saldo devedor: R$ %.2f reais%n%n",
												saldoDev);

									} else {
										System.out.printf("%d%c mes - Valor da Parcela: R$ %.2f reais%n", i, 248, pmt);
										System.out.printf("Valor fixo mensal de amortização: R$ %.2f reais%n", amort);
										System.out.printf("Valor atualizado do juros: R$ %.2f reais%n", jurosAtual);
										System.out.printf("Saldo devedor: R$ %.2f reais%n%n", saldoDev);

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
}
