package templates;

import java.util.NoSuchElementException;

public class LinkedList {

	private Node head, tail;
	private int size;

	public LinkedList() {
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void addFirst(int valor) {
		Node newNode = new Node(valor);
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		this.size++;	
	}

	public void addLast(int valor) {
		Node newNode = new Node(valor);
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			newNode.prev = tail;
			this.tail = newNode;
		}
		this.size++;
	}

	// adiciona um valor na posição passada como parâmetro
	public void add(int index, int valor) {
		if(index < 0 || index > this.size) throw new IndexOutOfBoundsException();
		
		Node newNode = new Node(valor);
		if(index == 0) {
			this.addFirst(valor);
		} else if(index == this.size) {
			this.addLast(valor);
		} else {
			Node aux = this.head;
			for(int i = 0; i < index - 1; i++) {
				aux = aux.next;
			}
			newNode.next = aux.next;
			aux.next = newNode;
			aux.next.prev = newNode;
			newNode.prev = aux;
			
			size++;
		}	
	}

	public int getFirst() {
		if(isEmpty()) throw new NoSuchElementException();
		return this.head.value;
	}

	public int getLast() {
		if(isEmpty()) throw new NoSuchElementException();
		return this.tail.value;
	}

	// retorna o elemento na posição passada como parâmetro
	// deve lançar IndexOutOfBoundsException se o índice não for válido.
	public int get(int index) {
		if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
		
		Node aux = this.head;
		for(int i = 0; i < index; i++) {
			aux = aux.next;
		}
		return aux.value;
	}

	// deve lançar exceção caso a fila esteja vazia.
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

	// deve lançar exceção caso a fila esteja vazia.
	public int removeLast() {
		return -1;
	}

	// remove o valor no índice passado como parâmetro. retorna o valor removido.
	// lançar exceção se o índice não for válido.
	public int remove(int index) {
		return -1;
	}

	// remove a primeira ocorrência do elemento cujo valor foi passado como
	// parâmetro.
	// se não encontrar, não faça nada. true se remover, false se não remover.
	public boolean removeByValue(int value) {
		return false;
	}

	// retorna a posição da primeira ocorrência do valor passado como parâmetro.
	public int indexOf(int value) {
		
		Node aux = this.head;
		int index = 0;
		while(aux != null) {
			if(aux.value == value) {
				return index;
			}
			aux = aux.next;
			index++;
		}
		return -1;
	}

	public boolean contain(int v) {
		return indexOf(v) != -1;
	}

	// Deve retornar a posição da última ocorrência do elemento passado como
	// parâmetro.
	public int lastIndexOf(int valor) {
		return -1;
	}

	// deve retornar uma string representando a lista.
	public String toString() {
		if (isEmpty())
			return "";

		Node aux = this.head;
		String out = "";
		while (aux != null) {
			out += aux.value + ", ";
			aux = aux.next;
		}
		return out.substring(0, out.length() - 2);
	}

	public int size() {
		return this.size;
	}

	// move o elemento que está na posição index para a cabeça da lista.
	// a busca pelo elemento é O(n), mas a movimentação em si deve ser O(1),
	// ou seja, feita só manipulando referências.
	public void moveToHead(int index) {
		if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
		
		Node aux = this.head;
		for(int i = 0; i < index; i++) {
			aux = aux.next;
		}
		if(aux != this.head) {
			aux.next = this.head;
			this.head.prev = aux;
		}
	}

	// dado que a lista já está em ordem crescente, insere v no lugar certo
	// para que a lista continue ordenada depois da inserção. se já houver
	// elementos iguais a v na lista, insira v depois deles.
	public void insereOrdenado(int v) {
	}

	// troca n1 e n2 de posição na lista. não é permitido trocar os valores
	// guardados nos nós, só manipular as referências (prev/next). esse
	// algoritmo deve ser O(1), já que os nós a trocar são recebidos como
	// parâmetro (ou seja, não é permitido percorrer a lista para achá-los).
	public void swap(Node n1, Node n2) {
	}

	// inverte a lista: tail passa a ser head, o elemento anterior ao tail
	// passa a ser o segundo da lista e assim por diante, até chegar em
	// head, que passa a ser o último elemento (tail). não é permitido usar
	// nenhuma estrutura auxiliar.
	public void inverte() {
	}

	// retorna uma string representando a lista no sentido inverso, do tail
	// para o head, usando os ponteiros prev (e não next). serve para provar
	// que a implementação é de fato duplamente encadeada.
	public String toStringReverso() {
		return null;
	}

	// remove todas as ocorrências de valor na lista (diferente de
	// removeByValue, que remove só a primeira ocorrência). retorna quantas
	// remoções foram feitas.
	public int removeAll(int valor) {
		return -1;
	}

	// retorna um array com os elementos da lista, na mesma ordem em que
	// aparecem (do head para o tail).
	public int[] toArray() {
		return null;
	}

	// retorna o valor do elemento do meio da lista, usando dois ponteiros
	// (um avança uma posição por vez, o outro avança duas) em uma única
	// passada pela lista. se a lista tiver tamanho par, retorne o segundo
	// dos dois elementos centrais.
	public int meio() {
		return -1;
	}

	// retorna true se a lista for um palíndromo, isto é, se lê-la do head
	// para o tail dá a mesma sequência de valores que lê-la do tail para o
	// head. aproveite o fato de a lista ser duplamente encadeada para
	// resolver isso em O(n) tempo e O(1) espaço extra, sem array ou pilha
	// auxiliar.
	public boolean isPalindromo() {
		return false;
	}

	// retorna o nó na posição index. existe só para permitir que os testes
	// de swap peguem referências reais de nós da lista (fora da classe não
	// há outro jeito de obter um Node).
	public Node getNode(int index) {
		return null;
	}

	// remove a última ocorrência do elemento cujo valor foi passado como
	// parâmetro (diferente de removeByValue, que remove a primeira).
	// se não encontrar, não faça nada. true se remover, false se não remover.
	public boolean removeLastOccurrence(int valor) {
		return false;
	}

	// remove da lista, em efeito colateral (sem criar uma lista nova), todo
	// elemento cujo valor seja menor ou igual a valor. ao final, a lista só
	// deve ter elementos estritamente maiores que valor.
	public void filter(int valor) {
	}
}

class Node {

	int value;
	Node prev;
	Node next;

	Node(int v) {
		this.value = v;
	}

}
