package templates;

public class Aluno {
	
	private String nome;
	private int matricula;
	
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
        if (!(obj instanceof Aluno))
            return false;
        
        Aluno test = (Aluno) obj;
        return test.getMatricula() == this.matricula;
    }
    
    public String toString() {
        return nome;
    }
}
