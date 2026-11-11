package templatesCacheFIFO;

import java.util.NoSuchElementException;

public class FIFOCache {
	private String[] fila;
	private int tail, head, size;
    
	// sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public FIFOCache(int capacidade) {
        this.fila = new String[capacidade];
        this.head = -1;
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }

    public boolean isFull() {
        return this.size == fila.length;
    }

    // deve sobrescerver o mais antigo caso a fila esteja cheia.
    public void addLast(String chave) {
    	if(!isFull()) {
    		this.size++;
    	}
    	if(isEmpty()) {
    		this.head = 0;
    		this.tail = 0;
    		this.fila[tail] = chave;
    	}
    	if(isFull()){
    		this.head = (this.head + 1) % this.fila.length;
    	}
    	this.tail = (this.tail + 1) % this.fila.length;
    	this.fila[tail] = chave;
    	
    }

    // deve lançar exceção caso a fila esteja vazia.
    public String removeFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        
        String saida = this.fila[head];
        
        if(head == tail) {
        	this.head = -1;
        	this.tail = -1;
        } else {
        	this.head = (this.head + 1) % this.fila.length;
        }
        this.size--;
        return saida;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public String getFirst() {
    	if(isEmpty()) throw new NoSuchElementException();
        return this.fila[head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public String getLast() {
    	if(isEmpty()) throw new NoSuchElementException();
        return this.fila[tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        return "";
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean contains(String chave) {
    	for(int i = 0; i < this.fila.length; i++) {
    		if(fila[i] == chave) {
    			return true;
    		}
    	}
    	return false;
    }
}