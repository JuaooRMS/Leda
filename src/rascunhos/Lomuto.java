package rascunhos;

import java.util.*;
class Lomuto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];
		for(int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		int i = sc.nextInt();
		int j = sc.nextInt();
		System.out.println(partition(seq, 0, seq.length - 1, i, j));
	}
	
	public static int partition(int[] seq, int ini, int fim, int i, int j) {
		int menorI = 0;
		int maiorI = 0;
		int menorJ = 0;
		int maiorJ = 0;
		for(int k = 0; k < seq.length; k++) {
			if(seq[k] >= i) maiorI++;
			else if(seq[k] < i) menorI++;
			else if(seq[k] >= j) maiorJ++;
			else if(seq[k] < j) menorJ++;
		}
		if(Math.abs(maiorI - menorI) < Math.abs(maiorJ - menorJ)) return j;
		else if (Math.abs(maiorJ - menorJ) < Math.abs(maiorI - menorI)) return i;
		else return i;
	}
}