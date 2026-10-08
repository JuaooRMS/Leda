package tstLeda;

import java.util.*;
class EstatiscaOrdem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];

		for (int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		System.out.println(enesimo(seq));
		particion(seq, 0, seq.length-1);
		System.out.println(Arrays.toString(seq));
	}
	
	public static int enesimo(int[] seq) {
		int alvo = seq[0];
		int maioresQueAlvo = 0;
		for(int i = 1; i < seq.length; i++) {
			if(seq[i] > alvo) {
				maioresQueAlvo++;
			}
		}
		return seq.length-maioresQueAlvo;
	}
	public static void particion(int[] seq, int ini, int fim) {
		int pivot = seq[ini];
		int i = ini;
		for(int j = ini + 1; j <= fim; j++) {
			if(seq[j] <= pivot) {
				i++;
				swap(seq, i, j);
			}
		}
		swap(seq, ini, i);
	}
	
	public static void swap(int[] seq, int i, int j) {
		int aux = seq[i];
		seq[i] = seq[j];
		seq[j] = aux;
	}
}
