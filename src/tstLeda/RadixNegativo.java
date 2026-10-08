package tstLeda;

import java.util.*;

public class RadixNegativo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] entrada = sc.nextLine().split(" ");
		int quantDigito = sc.nextInt();
		int[] seq = new int[entrada.length];

		for (int i = 0; i < entrada.length; i++) {
			seq[i] = Integer.parseInt(entrada[i]);
		}
		seq = radixSort(seq);
    }

    public static int maior(int[] seq) {
        int maior = seq[0];
        for (int i = 1; i < seq.length; i++) {
            if (seq[i] > maior) {
                maior = seq[i];
            }
        }
        return maior;
    }

    public static int[] radixSort(int[] A) {
        int maxNum = maior(A);

        for (int posicao = 1; maxNum / posicao > 0; posicao *= 10) {
        	A = countingSort(A, posicao);
        	System.out.println(Arrays.toString(A));
        }
        return A;
    }
    public static int[] countingSort(int[] A, int posicao) {
    	
    	int[] C = new int[10];
    	for(int i = 0; i < A.length; i++) {
    		int digito = (A[i]/posicao) % 10;
    		C[digito] += 1; 
    	}
    	
    	for(int i = 1; i < C.length; i++) {
    		C[i] += C[i - 1];
    	}
    	
    	int[] B = new int[A.length];
    	for(int i = A.length - 1; i >= 0; i--) {
    		int digito = (A[i]/posicao) % 10;
    		B[C[digito] -1] = A[i];
    		C[digito] -= 1;
    	}
    	return B;
    }
}
