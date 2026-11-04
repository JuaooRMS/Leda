package templates;

import java.util.ArrayList;

public class FuncoesHash {
	private ArrayList<Aluno>[] tabela;
    private final int CAPACIDADE_DEFAULT = 20;

    
    public FuncoesHash() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }
    
    
    public FuncoesHash(int capacidade) {
        this.tabela = new ArrayList[capacidade];
    }
    
    
    private int hash(int chave) {
        return Math.abs(chave % this.tabela.length);
    }
    
	private int Knut(int chave) {
	    double A = 0.6180339887;
	    double fracao = (chave * A) % 1;
	    return (int) (tabela.length * fracao);
	}
	
}
