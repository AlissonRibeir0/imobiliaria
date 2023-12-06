package util;

public class Style {
	
	public static final int MAX = 80;
	
	public static void linha(int qtd) {
		for (int i = 0; i < qtd; i++) {
			System.out.print("=");
		}
		System.out.println();
		System.out.println();
	}

	public static void styleLine(int qtd) {
		for (int i = 0; i < qtd; i++) {
			System.out.print("=");
		}
	}
}
