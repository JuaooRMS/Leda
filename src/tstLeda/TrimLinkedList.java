package tstLeda;

import java.util.*;

public class TrimLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		String[] entrada = sc.nextLine().split(" ");
		int alvo = sc.nextInt();
		
		TrimLinkedList linked = new TrimLinkedList();
		for(String s : entrada) {
			linked.addLast(Integer.parseInt(s));
		}
		System.out.println(linked.trimLinked(alvo));
	}
	private Node tail, head;
	private int size;
	private int alvo;
	
	public TrimLinkedList() {
		
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void addLast(int value) {
		Node newNode = new Node(value);
		if(isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.size++;
	}
	public int removeFirst() {
		if(isEmpty()) throw new NoSuchElementException();
		int saida = this.head.value;
		if(this.head.next == null) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
			this.head.prev = null;
		}
		this.size--;
		return saida;
	}
	
	public int removeLast() {
		if(isEmpty()) throw new NoSuchElementException();
		int saida = this.tail.value;
		if(this.head.next == null) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		this.size--;
		return saida;
	}
	
	public int remove(int index) {
		if(index < 0 || index > this.size) throw new IndexOutOfBoundsException();
		
		if(index == 0) removeFirst();
		else if(index == this.size - 1) removeLast();
		Node aux = this.head;
		for(int i = 0; i < index; i++) {
			aux = aux.next;
		}
		aux.prev.next = aux.next;
		aux.next.prev = aux.prev;
		this.size--;
		return aux.value;
	}
	
	public String toString() {
		if(isEmpty()) return "vazia";
		
		String saida = "";
		Node aux = this.head;
		while(aux != null) {
			saida += aux.value + " ";
			aux = aux.next;
		}
		return saida.substring(0, saida.length() - 1);
	}
	
	public String trimLinked(int alvo) {
		if(isEmpty()) throw new NoSuchElementException();
		Node aux = this.head;
		Node aux2 = this.tail;
		if(this.head.next == null) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			for(int i = 0; i < alvo - 1; i++) {
				aux = aux.next;
				aux2 = aux2.prev;
			}
			if(aux == this.head || aux == this.tail ) {
				removeFirst();
				removeLast();
			} else if (aux == aux2){
				aux.prev.next = aux.next;
				aux.next.prev = aux.prev;
				this.size--;
			} else {
				aux.prev.next = aux.next;
				aux.next.prev = aux.prev;
				aux2.prev.next = aux2.next;
				aux2.next.prev = aux2.prev;
				this.size--;
			}
		}
		return toString();
	}
	
}
