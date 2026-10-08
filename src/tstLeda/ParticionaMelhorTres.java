package tstLeda;

import java.util.*;

class ParticionaMelhorTres {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];

		for (int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
	}
	
	public static int partition(int[] seq, int ini, int fim) {
		int indexMedio = calculaMediana(seq, ini, fim);
	    swap(seq, ini, indexMedio);
		
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
	
	public static int calculaMediana(int[] seq, int ini, int fim) {
	    int meio = (ini + fim) / 2;

	    int[] mediana = {seq[ini], seq[meio], seq[fim]};
	    Arrays.sort(mediana);

	    if (mediana[1] == seq[ini]) {
	        return ini;
	    } else if (mediana[1] == seq[meio]) {
	        return meio;
	    } else {
	        return fim;
	    }
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
}
