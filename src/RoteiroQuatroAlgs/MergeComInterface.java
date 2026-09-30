package RoteiroQuatroAlgs;

import java.util.Arrays;
import java.util.Scanner;

public class MergeComInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];
		
		for(int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		MergeComInterface ordenado = new MergeComInterface();
		ordenado.sort(seq, 0, seq.length - 1);
		System.out.println(Arrays.toString(seq));
	}
	
	public void merge(int[] seq, int ini, int fim) {
		
		int indexAux = fim - ini;
		int[] arrayAux = new int[indexAux + 1];
		for(int i = 0; i <= indexAux; i++) {
			arrayAux[i] = seq[ini + i];
		}
		
		int meio = indexAux/2;
		int i = 0;
		int j = meio + 1;
		int k = ini;
		
		while(i <= meio && j <= indexAux) {
			if(arrayAux[i] <= arrayAux[j]) {
				seq[k] = arrayAux[i];
				i++;
			} else {
				seq[k] = arrayAux[j];
				j++;
			}
			k++;
		}
		
		while(i <= meio) {
			seq[k] = arrayAux[i];
			i++;
			k++;
		}
	}
	
	public void sort(int[] seq, int ini, int fim) {
		if(ini >= fim) {
			return;
		} else {
			int meio = (ini+fim)/2;
			sort(seq, ini, meio);
			sort(seq, meio + 1, fim);
			
			merge(seq, ini, fim);
		}
	}
}
