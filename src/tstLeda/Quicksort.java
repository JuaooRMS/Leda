package tstLeda;

import java.util.*;

class Quicksort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];

		for (int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		
		quickSort(seq, 0, seq.length - 1);
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
		System.out.println(Arrays.toString(seq));
		return i;
	}
	
	public static void swap(int[] v, int i, int j) {
		int aux = v[j];
		v[j] = v[i];
		v[i] = aux;
	}
	
	public static void quickSort(int[] seq, int ini, int fim) {
		if(ini < fim) {
			int indexPivot = partition(seq, ini, fim);
			quickSort(seq, ini, indexPivot - 1);
			quickSort(seq, indexPivot + 1, fim);
		}
	}
	
}