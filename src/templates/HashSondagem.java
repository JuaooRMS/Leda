package templates;

import java.util.ArrayList;

public class HashSondagem {
	
	private ArrayList<Aluno>[] tabela;
	private final int CAPACIDADE_DEFAULT = 20;
	
	public HashSondagem() {
		this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
	}
	
	public HashSondagem(int capacidade) {
		this.tabela = new ArrayList[capacidade];
	}
	
	public int hash(int chave) {
		return chave % this.tabela.length;
	}
}
