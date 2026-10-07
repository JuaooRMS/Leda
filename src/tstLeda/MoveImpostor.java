package tstLeda;

import java.util.*;
class MoveImpostor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];

		for (int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		int numImpostor = impostor(seq);
		quickSort(seq, seq[0], numImpostor);
		System.out.println(Arrays.toString(seq));
	}
	public static int impostor(int[] seq) {
		for(int i = 0; i < seq.length; i++) {
			if(seq[i] > seq[i + 1]) {
				return seq[i+1];
			}
		}
		return -1;
	}
	
	public static int partition(int[] seq, int ini, int fim) {
		int pivot = seq[ini];
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
			int indexAux = partition(seq, ini, fim);
			quickSort(seq, ini, indexAux - 1);
			quickSort(seq, indexAux + 1, fim);
		}
	}
	
	public static void swap(int[] seq, int i, int j) {
		int aux = seq[i];
		seq[i] = seq[j];
		seq[j] = aux;
	}
}
