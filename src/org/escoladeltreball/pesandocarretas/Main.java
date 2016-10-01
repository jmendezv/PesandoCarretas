package org.escoladeltreball.pesandocarretas;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	private static final int MAX_PES = 100;

	private static Scanner scanner = new Scanner(System.in);
	private static int[] pesades = new int[10];

	public static void main(String[] args) {
		// out.printf("%s%n", "Solving...");
		int n = scanner.nextInt();	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				pesades[j] = scanner.nextInt();
			}
			solve(pesades, Arrays.stream(pesades).max().getAsInt());
			//solve(pesades, IntStream.of(pesades).max().getAsInt());
		}

	}

	private static void solve(int[] pesades, int max) {
		int[] carros = new int[5];
		for (int c1 = 1; c1 <= MAX_PES; c1++) {
			if (c1 >= max) {
				break;
			}
			for (int c2 = 1; c2 <= MAX_PES; c2++) {
				if (c2 >= max) {
					break;
				}
				for (int c3 = 1; c3 <= MAX_PES; c3++) {
					if (c3 >= max) {
						break;
					}
					for (int c4 = 1; c4 <= MAX_PES; c4++) {
						if (c4 >= max) {
							break;
						}
						for (int c5 = 1; c5 <= MAX_PES; c5++) {
							carros[0] = c1;
							carros[1] = c2;
							carros[2] = c3;
							carros[3] = c4;
							carros[4] = c5;
							if (check(carros)) {
								Arrays.sort(carros);
								out.printf("%d %d %d %d %d%n", carros[4],
										carros[3], carros[2], carros[1],
										carros[0]);
								return;
							}
							if (c5 >= max) {
								break;
							}
						}
					}
				}
			}
		}
		out.printf("%s%n", "No s'ha trobat solució");
	}

	private static boolean check(int[] carros) {
		int[] pesos = new int[] { carros[0] + carros[1], carros[0] + carros[2],
				carros[0] + carros[3], carros[0] + carros[4],
				carros[1] + carros[2], carros[1] + carros[3],
				carros[1] + carros[4], carros[2] + carros[3],
				carros[2] + carros[4], carros[3] + carros[4] };
		Arrays.sort(pesos);
		// out.println(Arrays.toString(carros));
		// out.println(Arrays.deepToString(carros));
		// int min = Arrays.asList(carros).stream().max(Integer::compare).get();

		return Arrays.equals(pesos, pesades);
	}

}
