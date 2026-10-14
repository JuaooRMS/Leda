package tstLeda;

import java.util.*;
class ParticionaLomutoUltimo {
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
		int pivot = seq[fim];
		int i = fim;
		
		for(int j = fim - 1; j >= ini; j--) {
			if(seq[j] >= pivot) {
				i--;
				swap(seq, i, j);
				System.out.println(Arrays.toString(seq));
			}
		}
		swap(seq, fim, i);
		System.out.println(Arrays.toString(seq));
	}
	
	public static void swap(int[]seq, int i, int j) {
		int aux = seq[i];
		seq[i] = seq[j];
		seq[j] = aux;
	}
}
