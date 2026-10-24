package templates;

import java.util.*;
public class ArrayList {
	
	private int[] lista;
	private int tamanho;
	public static final int CAPACIDADE_DEFAULT = 20;
	
	public ArrayList() {
		this(CAPACIDADE_DEFAULT);
	}
	
    public ArrayList(int capacidadeInicial) {
        this.lista = new int[capacidadeInicial];
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public void addFirst(int valor) {
    	assegureCapacidade(this.tamanho + 1);
    	shiftRight(0);
    	this.lista[0] = valor;
    	this.tamanho++;
    }

    public void addLast(int valor) {
    	assegureCapacidade(tamanho + 1);
    	this.lista[this.tamanho++] = valor;
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        if(index < 0 || index > tamanho) throw new IndexOutOfBoundsException();
        
        assegureCapacidade(this.tamanho + 1);
        shiftRight(index);
        this.lista[index] = valor;
        this.tamanho++;
        
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
       int[] newLista = new int[novaCapacidade];
       for(int i = 0; i < this.lista.length; i++) {
    	   newLista[i] = this.lista[i];
       }
       this.lista = newLista;
    }

    public void assegureCapacidade(int capacidadePretendida) {
       if(capacidadePretendida > this.lista.length) {
    	   resize(Math.max(this.lista.length * 2, capacidadePretendida));
       }
    }

    public int getFirst() {
    	if(isEmpty()) throw new NoSuchElementException();
        return this.lista[0];
    }

    public int getLast() {
    	if(isEmpty()) throw new NoSuchElementException();
        return this.lista[tamanho - 1];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if(index < 0 || index >= tamanho) throw new IndexOutOfBoundsException();
        return this.lista[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
    	if(isEmpty()) throw new NoSuchElementException();
    	int saida = this.lista[0];
    	shiftLeft(0);
    	this.tamanho--;
        return saida;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
    	if(isEmpty()) throw new NoSuchElementException();
    	shiftLeft(tamanho - 1);
    	this.tamanho--;
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
    	if(index < 0 || index >= tamanho) throw new IndexOutOfBoundsException();
    	shiftLeft(index);
    	this.tamanho--;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        for(int i = 0; i < this.tamanho - 1; i++) {
        	if(lista[i] == value) {
        		remove(i);
        	}
        }
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
    	for(int i = 0; i < this.tamanho - 1; i++) {
        	if(lista[i] == value) {
        		return i;
        	}
    	}
        return -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
    	int saida = -1;
    	for(int i = 0; i < this.tamanho - 1; i++) {
        	if(lista[i] == valor) {
        		saida = i;
        	}
    	}
        return saida;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        return "";
    }
    
    public int size() {
        return this.tamanho;
    }
    
    public void shiftRight(int index) {
    	if(index == this.lista.length - 1) throw new IndexOutOfBoundsException();
    	for(int i = this.tamanho; i > index; i--) {
    		this.lista[i] = this.lista[i - 1];
    	}
    }
    
    public void shiftLeft(int index) {
    	for(int i = index; i < this.tamanho - 1; i++) {
    		this.lista[i] = this.lista[1 + i];
    	}
    }
}
