package tstLeda;

import java.util.*;

public class InvertePilhaIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] entrada = sc.nextLine().split(" ");
		InvertePilhaIndex pilha = new InvertePilhaIndex(entrada.length);

	    for (int i = 0; i < entrada.length; i++) {
	        pilha.push(Integer.parseInt(entrada[i]));
	    }
	    System.out.println(pilha.retornaMaior());
	}
	private int[] pilha;
	private int topo;
	
	
	public InvertePilhaIndex(int capacidade) {
		this.pilha = new int[capacidade];
		this.topo = -1;
	}
	
	public boolean isEmpty() {
		return this.topo == -1;
	}
	
	public boolean isFull() {
		return this.topo + 1 == this.pilha.length; 
	}
	
	public void push(int valor) {
		if(isFull()) throw new RuntimeException("cheio");
		this.pilha[++this.topo] = valor;
	}
	
	public int pop() {
		if(isEmpty()) throw new NoSuchElementException("vazio");
		return this.pilha[this.topo--];
	}
	
	public int peek() {
		if(isEmpty()) throw new NoSuchElementException("vazio");
		return this.pilha[this.topo];
	}
	
	public int retornaMaior() {
		if(isEmpty()) throw new NoSuchElementException("vazio");
		InvertePilhaIndex aux = new InvertePilhaIndex(this.pilha.length);
		int maior = this.pilha[this.topo];
		int indice = this.topo;
		
		while(!isEmpty()) {
			int elemento = pop();
			if(elemento > maior) {
				maior = this.pilha[indice];
			}
			
			aux.push(elemento);
			indice--;
		}
		
		while(!aux.isEmpty()) {
			push(aux.pop());
		}
		return maior;
	}
}
