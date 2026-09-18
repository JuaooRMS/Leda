package tstLeda;

import java.util.*;

class EncontraPrimeiroNegativo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] seq = sc.nextLine().split(" ");
		EncontraNeg(seq);
	}
	public static String EncontraNeg(String[] s) {
		for(int i = 0; i < s.length; i++) {
			if(Integer.parseInt(s[i]) < 0) {
				return s[i];
			}
		}
		return " - ";

	}
}
