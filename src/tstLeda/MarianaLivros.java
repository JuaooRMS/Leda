package tstLeda;

import java.util.*;
class MarianaLivros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(",");
		InsertionSort(entrada);
		String saida = "";
		for(int i = 0; i < entrada.length; i ++) {
			if(i != entrada.length-1) {
				saida += entrada[i] + ", ";
			} else {
				saida += entrada[i];
			}
		}
		System.out.println(saida.trim());
			
	}
	
	public static void InsertionSort(String[] seq) {
		for(int i = 1; i < seq.length; i++) {
			int j = i;
			while(j > 0 && seq[j].compareTo(seq[j - 1]) < 0) {
				String aux = seq[j];
				seq[j] = seq[j - 1];
				seq[j - 1] = aux;
				j--;
				System.out.println(Arrays.toString(seq));
			}
		}
	}

}
