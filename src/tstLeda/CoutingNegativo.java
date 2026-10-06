package tstLeda;

import java.util.*;
class CoutingNegativo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			String[] entrada = sc.nextLine().split(" ");
			int[] A = new int[entrada.length];
			for(int i = 0; i < entrada.length; i++) {
				A[i] = Integer.parseInt(entrada[i]);
			}
			int maiorElem = sc.nextInt();
			int menorElem = sc.nextInt();
			System.out.println(Arrays.toString(couting(A, maiorElem, menorElem)));
	}
	
	public static int[] couting(int[] A, int k, int l) {
		int[] C = new int[k - l + 1];
		for(int i = 0; i < A.length; i++) {
			C[A[i]- l] += 1;
			System.out.println(Arrays.toString(C));	
		}
		
		for(int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		System.out.println("Cumulativa do vetor de contagem - " +Arrays.toString(C));
		int[] B = new int[A.length];
		for(int i = A.length -1; i >= 0; i--) {
			B[C[A[i]- l]- 1] = A[i];
			C[A[i]- l] -= 1;
		}
		System.out.println(Arrays.toString(C));
		return B;
	}
}
