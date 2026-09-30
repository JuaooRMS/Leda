package tstLeda;

import java.util.*;
class InsertionRecursivo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			String[] entrada = sc.nextLine().split(" ");
			int[] seq = new int[entrada.length];
			for(int i = 0; i < entrada.length; i++) {
				seq[i] = Integer.parseInt(entrada[i]);
			}
			insertion(seq, 1);
	}
	public static void insertion(int[] seq, int i) {
		if(i >= seq.length) {
			return;
		}
		int j = i;
			
		while(j > 0 && seq[j] <= seq[j-1]) {
			swap(seq, j, j - 1);
			j--;
		}
		System.out.println(Arrays.toString(seq));
		insertion(seq, i+1);
		
	}
	public static void swap(int[] seq, int i, int j) {
		int aux = seq[i];
		seq[i] = seq[j];
		seq[j] = aux;
	}
}
