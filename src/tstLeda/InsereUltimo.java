package tstLeda;

import java.util.*;

class InsereUltimo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] seq = sc.nextLine().split(" ");
		InsereOrdenadoUltimo(seq);
		System.out.println(Arrays.toString(seq));
}	
	public static void InsereOrdenadoUltimo(String[] seq) {
		for(int i = 0; i < seq.length; i++) {
			
			int primeiro = i;	
			
			for(int j = i + 1; j < seq.length; j++) {
				if(Integer.parseInt(seq[j]) > Integer.parseInt(seq[primeiro])) {					
					primeiro = j;
				}
			String aux = seq[j];
			seq[j] = seq[primeiro];
			seq[primeiro] = aux;
			}
		}
	}
}
