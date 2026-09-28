package tstLeda;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortPassoAPasso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];

		for (int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		
		mergeSort(seq, 0, seq.length - 1);
        
        System.out.println(Arrays.toString(seq));
	}

	public static void merge(int[] seq, int ini, int fim) {
		int indiceAux = fim - ini;
		int[] arrayAux = new int[indiceAux + 1];

		for (int i = 0; i <= indiceAux; i++) {
			arrayAux[i] = seq[ini + i];
		}

		int meio = indiceAux / 2;

		int i = 0;
		int j = meio + 1;
		int k = ini;

		while (i <= meio && j <= indiceAux) {
			if (arrayAux[i] <= arrayAux[j]) {
				seq[k] = arrayAux[i];
				i++;
			} else {
				seq[k] = arrayAux[j];
				j++;
			}
			k++;
		}
		while (i <= meio) {
			seq[k] = arrayAux[i];
			i++;
			k++;
		}
	}

	public static void mergeSort(int[] seq, int ini, int fim) {
		if (ini >= fim) {
			return;

		} else {
			int meio = (ini + fim) / 2;
			mergeSort(seq, ini, meio);
			mergeSort(seq, meio + 1, fim);

			merge(seq, ini, fim);
		}
	}
}
