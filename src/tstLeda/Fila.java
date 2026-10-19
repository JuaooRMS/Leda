package tstLeda;

import java.util.*;

public class Fila {
	
	private int[] fila;
	private int head, tail, size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }

    public boolean isFull() {
    	return this.size == this.fila.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
    	if(isFull()) throw new RuntimeException("fila cheia");
    	
    	if(isEmpty()) this.head = 0;
    	
    	this.tail = (this.tail + 1) % this.fila.length;
    	this.fila[this.tail] = valor;
    	this.size++;
    }
    
    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("Coleção vazia");
        
        int saida = fila[this.head];
        
        if(this.head == this.tail) {
        	this.head = -1;
        	this.tail = -1;
        } else {
        	this.head = (this.tail + 1) % this.fila.length;
        }
        this.size -= 1;
        return saida;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
    	if (isEmpty()) throw new NoSuchElementException("Coleção vazia");
        return this.fila[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
    	if (isEmpty()) throw new NoSuchElementException("Coleção vazia");
        return this.fila[this.tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        return "";
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        return -1;
    }
    
    public int size() {
        return this.size;
    }

}
