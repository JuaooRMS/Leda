package tstLeda;


public class Pair {
	
	private String nome;
	private int matricula;
	
	public Pair(int matricula, String nome) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public int getMatricula() {
		return this.matricula;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
    public int hashCode() {
        return this.matricula;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair))
            return false;
        
        Pair test = (Pair) obj;
        return test.getMatricula() == this.matricula;
    }
    
    public String toString() {
        return nome;
    }
}

