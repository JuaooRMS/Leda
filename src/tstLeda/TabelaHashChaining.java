package tstLeda;

import java.util.ArrayList;
import java.util.*;
public class TabelaHashChaining {
	
	private ArrayList<Pair>[] tabela;
	private ArrayList<Integer> keys;
	private ArrayList<Pair> values;
	
	@SuppressWarnings("unchecked")
	public TabelaHashChaining(int capacidade) {
		this.tabela = (ArrayList<Pair>[]) new ArrayList[capacidade];
		this.keys = new ArrayList<Integer>();
		this.values = new ArrayList<Pair>();
	}
	
	public int hash(int chave) {
		return chave % this.tabela.length;
	}
	
	public void put(int chave, Pair valor) {
		int hash = hash(chave);
		ArrayList<Pair> pares = this.tabela[hash];
		
		if(pares == null) {
			pares = new ArrayList<Pair>();
			pares.add(valor);
			this.tabela[hash] = pares;
		} else {
			for(int i = 0; i < pares.size(); i++) {
				if(pares.get(i).getMatricula() == chave) {
					pares.set(i, valor);
					return;
				}
			}
			pares.add(valor);
			keys.add(chave);
			values.add(valor);
		}
	}
	
	public Pair remove(int chave) {
		int hash = hash(chave);
		ArrayList<Pair> pares = this.tabela[hash];
		
		Iterator<Pair> it = pares.iterator();
		Pair atual = null;
		
		while(it.hasNext()) {
			atual = it.next();
			if(atual.getMatricula() == chave) {
				it.remove();
				keys.remove(chave);
				return atual;
			}	
		}
		return atual;
	}
	
	
}
