package RoteiroQuatroAlgs;

import java.util.*;

public class InsertionComInterface implements Sorting{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];
		
		for(int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		InsertionComInterface ordenador = new InsertionComInterface();
        ordenador.sort(seq);
        System.out.println(Arrays.toString(seq));
	}
	@Override
	public void sort(int[] seq) {
		for(int i = 1; i < seq.length; i++) {
			int j = i;
			
			while(j > 0 && seq[j] < seq[j - 1]) {
				int aux = seq[j];
				seq[j] = seq[j - 1];
				seq[j - 1] = aux;
				j--;
			}
		}
	}
}