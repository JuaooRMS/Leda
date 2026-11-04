package tstLeda;

import java.util.*;

public class FiltraLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] entrada = sc.nextLine().split(" ");
		int alvo = sc.nextInt();
		
		FiltraLinkedList linked = new FiltraLinkedList();
		for(String s : entrada) {
			linked.addLast(Integer.parseInt(s));
		}
		
		System.out.println(linked.filtra(alvo));
	}
	private Node head, tail;
	private int size;
	private int alvo;
	
	public FiltraLinkedList() {
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void addFirst(int value) {
		Node newNode = new Node(value);
		if(isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		this.size++;
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
	
	public void add(int value, int index) {
		if(index < 0 || index > this.size) throw new IndexOutOfBoundsException();
		Node newNode = new Node(value);
		if(index == 0) addFirst(value);
		else if(index == this.size) addLast(value);
		else {
			Node aux = this.head;
			for(int i = 0; i < index - 1; i++) {
				aux = aux.next;
			}
			newNode.next = aux.next;
			aux.next = newNode;
			newNode.next.prev = newNode;
			newNode.prev = aux;
			this.size++;
		}
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
		if(isEmpty()) throw new NoSuchElementException();
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
	
	public String filtra(int value) {
		if(isEmpty()) throw new NoSuchElementException();
		Node aux = this.head;
		int index = 0;
		while(aux != null) {
			if(aux.value == value) {
				if(index == 0) removeFirst();
				else if(index == this.size - 1) removeLast();
				else {
					aux.prev.next = aux.next;
					aux.next.prev = aux.prev;
					this.size--;
				}
			} else {	
				index++;
			}
			aux = aux.next;
		}
		return toString();
	}
	
	public String toString() {
		if(isEmpty()) return "vazia";
		
		Node aux = this.head;
		String saida = "";
		while(aux != null) {
			saida += aux.value + " ";
			aux = aux.next;
		}
		return saida.substring(0, saida.length() - 1);
	}
}

class Node {
	int value;
	Node next;
	Node prev;
	
	Node(int v){
		this.value = v;
	}
}
