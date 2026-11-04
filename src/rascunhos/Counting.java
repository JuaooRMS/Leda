package rascunhos;

import java.util.Arrays;
import java.util.Scanner;

public class Counting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] seq = new int[entrada.length];
		for(int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		seq = radixSort(seq);
	}
	
	public static int[] radixSort(int[] A) {
		int maiorNum = maior(A);
		
		for(int posicao = 1; maiorNum/posicao > 0; posicao *= 10) {
			A = counting(A, posicao);
			System.out.println(Arrays.toString(A));
		}
		return A;
	}
	
	public static int[] counting(int[] A, int posicao) {
		int[] C = new int[10];
		for(int i = 0; i < A.length; i++) {
			int digito = (A[i]/posicao)%10;
			C[digito]++;
		}
		
		for(int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		
		int[] B = new int[A.length];
		for(int i = A.length - 1; i >= 0; i--) {
			int digito = (A[i]/posicao)%10;
			B[C[digito] -1] = A[i];
			C[digito]--;
		}
		return B;
	}
	
	public static int maior(int[] seq) {
		int maior = seq[0];
		for(int i = 1; i < seq.length; i++) {
			if(seq[i] > maior) {
				maior = seq[i];
			}
		}
		return maior;
	}
}
