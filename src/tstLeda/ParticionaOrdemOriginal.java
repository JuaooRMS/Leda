package tstLeda;

import java.util.*;

class ParticionaOrdemOriginal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];

		for (int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		partition(seq, 0, seq.length-1);
		System.out.println(Arrays.toString(seq));
	}
	
	public static void partition(int[] seq, int ini, int fim) {
		int pivot = seq[ini];
		int i = ini;
		
		for(int j = ini + 1; j <= fim; j++) {
			if(seq[j] <= pivot) {
				i++;
				swap(seq, i, j);
			}
		}
		int k = ini;
		while(k < i) {
			swap(seq, k, k+1);
			k++;
		}
	}
	public static void swap(int[] seq, int i, int j) {
		int aux = seq[i];
		seq[i] = seq[j];
		seq[j] = aux;
	}
}
//                  7 1 3 8 19 18 2