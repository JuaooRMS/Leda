package templates;

import java.util.*;
public class Pilha {

	private int[] pilha;
	private int topo;
	
    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo + 1 == this.pilha.length;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if(isFull()) throw new RuntimeException("cheio");
        this.pilha[++this.topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if(isEmpty()) throw new NoSuchElementException("vazio");
        return this.pilha[this.topo--];
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if(isEmpty()) throw new NoSuchElementException("vazio");
        return this.pilha[this.topo];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        return "";
    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
    	if(isEmpty()) throw new NoSuchElementException("vazio");
    	
    	Pilha auxPilha = new Pilha(this.pilha.length);
    	int saida = -1;
    	int topo = this.topo;
    	while(!isEmpty()) {
    		int elemento = pop();
    		if(elemento == valor) {
    			saida = topo;
    		}
    		
    		auxPilha.push(elemento);
    		topo--;
    	}
    	
    	while(!auxPilha.isEmpty()) {
    		push(auxPilha.pop());
    	}
        return saida;
    }

    public int size() {
        return this.topo + 1;
    }

}
