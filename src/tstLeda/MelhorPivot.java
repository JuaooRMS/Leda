package tstLeda;

import java.util.*;

public class MelhorPivot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];

		for (int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		String[] entrada2 = sc.nextLine().split(" ");
		int[] possiveisPivots = new int[entrada2.length];
		
		for (int i = 0; i < entrada2.length; i++) {
			possiveisPivots[i] = Integer.parseInt(entrada2[i]);
		}
		quickSort(seq, possiveisPivots[0], possiveisPivots[1]);
		System.out.println(melhorPivot(seq, possiveisPivots[0], possiveisPivots[1]));
	}
	
	public static int partition(int[] seq, int ini, int fim) {
		int pivot = melhorPivot(seq, ini, fim);
		int i = ini;
		
		for(int j = ini + 1; j <= fim; j++) {
			if(seq[j] <= pivot) {
				i++;
				swap(seq, i, j);
			}
		}
		swap(seq, ini, i);
		return i;
	}
	
	public static void quickSort(int[] seq, int ini, int fim) {
		if(ini < fim) {
			int indexPivot = partition(seq, ini, fim);
			quickSort(seq, ini, indexPivot - 1);
			quickSort(seq, indexPivot + 1, fim);
		}
	}
	
	public static void swap(int[] seq, int i, int j) {
		int aux = seq[i];
		seq[i] = seq[j];
		seq[j] = aux;
	}
	
	public static int melhorPivot(int[] seq, int ini, int fim) {
		int menores1 = 0;
		int maiores1 = 0;
		int menores2 = 0;
		int maiores2 = 0;
		int melhor = 0;
		for(int k = 0; k < seq.length; k++) {
			if(seq[k] <= seq[ini]) {
				menores1++;
			} else {
				maiores1++;
			}
		}
		for(int k = 0; k < seq.length; k++) {
			if(seq[k] <= seq[fim]) {
				menores2++;
			} else {
				maiores2++;
			}
		}
		if(melhor == 0 || Math.abs(menores1 - maiores1) < melhor) {
			melhor = ini;
		}
		else if(melhor == 0 || Math.abs(menores2 - maiores2) < melhor) {
			melhor = fim;
		}
		return melhor;
	}
}
