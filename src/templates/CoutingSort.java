package templates;

import java.util.*;
class CoutingSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			String[] entrada = sc.nextLine().split(" ");
			int[] A = new int[entrada.length];
			for(int i = 0; i < entrada.length; i++) {
				A[i] = Integer.parseInt(entrada[i]);
			}
			int maiorElem = sc.nextInt();
			
			couting(A, maiorElem);
	}
	
	public static int[] couting(int[] A, int k) {
		int[] C = new int[k + 1];
		for(int i = 0; i < A.length; i++) {
			C[A[i]] += 1;
			System.out.println(formataSaida(C));
		}
		
		for(int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		System.out.println("Cumulativa do vetor de contagem - " + formataSaida(C));
		
		int[] B = new int[A.length];
		for(int i  = A.length - 1; i >= 0; i--) {
			B[C[A[i]] - 1] = A[i];
			C[A[i]] -= 1;		
		}
		System.out.println(formataSaida(C));
		System.out.println(formataSaida(B));
		return B;
	}
	
    public static String formataSaida(int[] entrada){
        String saida = "";
        for(int i = 0; i < entrada.length; i++){
            saida += entrada[i] + " ";
        }
        return saida.trim();
    }
}