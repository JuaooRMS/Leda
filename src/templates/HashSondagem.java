package templates;

import java.util.*;

public class HashSondagem {
	
	private Aluno[] tabela;
	private static final Aluno APAGADO = new Aluno(Integer.MIN_VALUE, "APAGADO");
	
	public HashSondagem() {
		this.tabela = new Aluno[20];
	}
	
	public int hash(int chave) {
		return chave % this.tabela.length;
	}
	
	public void put(int chave, Aluno valor) {
		int sondagem = 0;
		int hash;
		
		while(sondagem < tabela.length) {
			hash = (hash(chave) + sondagem) % tabela.length;
			
			if(tabela[hash] == null || tabela[hash].equals(APAGADO) || tabela[hash].getMatricula() == chave) {
				tabela[hash] = valor;
				return;
			}
			sondagem++;
		}
	}
	
	public void put2(int chave, Aluno valor) {
		int livre = -1; // primeiro índice disponível encontrado (null ou APAGADO)

		for (int sondagem = 0; sondagem < tabela.length; sondagem++) {
			int hash = (hash(chave) + sondagem) % tabela.length;
			Aluno atual = tabela[hash];

			if (atual == null) {
				if (livre == -1) livre = hash;
				break; // a chave não existe na tabela
			}

			if (atual == APAGADO) {
				if (livre == -1) livre = hash;
			} else if (atual.getMatricula() == chave) {
				tabela[hash] = valor; // chave já existe: atualiza
				return;
			}
		}

		if (livre == -1) throw new IllegalStateException("A tabela está cheia");
		tabela[livre] = valor;
	}
	
	public Aluno get(int chave) {
		int sondagem = 0;
		int hash;
		
		while(sondagem < this.tabela.length) {
			hash = (hash(chave) + sondagem) % tabela.length;
			
			if(tabela[hash] == null) {
				return null;
			}
			
			if(tabela[hash] != APAGADO && tabela[hash].getMatricula() == chave) {
				return tabela[hash];
			}
			
			sondagem++;
		}
		return null;
	}
	
	public Aluno remove(int chave) {
		int sondagem = 0;
		int hash;
		while(sondagem < tabela.length) {
			hash = (hash(chave) + sondagem) % tabela.length;
			
			if (tabela[hash] == null) return null;
			
			if(tabela[hash] != null && tabela[hash].getMatricula() == chave) {
				Aluno saida = tabela[hash];
				tabela[hash] = APAGADO;
				return saida;
			}
			sondagem++;
		}
		return null;
	}
}
