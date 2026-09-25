package tstLeda;

import java.util.*;

class InserePrimeiro {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] seq = sc.nextLine().split(" ");
		InsereOrdenadoUltimo(seq);
		System.out.println(Arrays.toString(seq));
}	
	public static void InsereOrdenadoUltimo(String[] seq) {
		for(int i = seq.length-1; i >= 0; i--) {
			
			int ultimo = i;	
			
			for(int j = i - 1; j >= 0; j--) {
				if(Integer.parseInt(seq[j]) < Integer.parseInt(seq[ultimo])) {					
					ultimo = j;
				}
			String aux = seq[j];
			seq[j] = seq[ultimo];
			seq[ultimo] = aux;
			}
		}
	}
}

