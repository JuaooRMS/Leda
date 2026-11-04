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

	// remove o valor no índice passado como parâmetro. retorna o valor removido.
	// lançar exceção se o índice não for válido.
	public int remove(int index) {
		if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
		
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

	// remove a primeira ocorrência do elemento cujo valor foi passado como
	// parâmetro.
	// se não encontrar, não faça nada. true se remover, false se não remover.
	public boolean removeByValue(int value) {
		if(isEmpty()) throw new NoSuchElementException();
		Node aux = this.head;
		for(int i = 0; i < this.size; i++) {
			if(aux.value == value) {
				if(i == 0) removeFirst();
				else if(i == this.size - 1) removeLast();
				else {
					aux.prev.next = aux.next;
					aux.next.prev = aux.prev;
					this.size--;
				}
				return true;
			}
			aux = aux.next;
		}
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
		if(aux == this.head) {
			return;
		} else {
			if(aux != this.tail) {
				aux.prev.next = aux.next;
				aux.next.prev = aux.prev;
			} else {
				aux.prev.next = null;
				this.tail = aux.prev;
			}
			aux.next = this.head;
			aux.prev = null;
			this.head.prev = aux;
			this.head = aux;
		}
	}

	// dado que a lista já está em ordem crescente, insere v no lugar certo
	// para que a lista continue ordenada depois da inserção. se já houver
	// elementos iguais a v na lista, insira v depois deles.
	public void insereOrdenado(int v) {
		Node newNode = new Node(v);
		if(isEmpty() || v < this.head.value) {
			addFirst(v);
			return;
		}
		if(v >= this.tail.value) {
			addLast(v);
			return;
		}
		Node aux = this.head;
		while(aux != null && aux.next.value <= v)
			aux = aux.next;
		newNode.next = aux.next;
		aux.next = newNode;
		newNode.next.prev = newNode;
		newNode.prev = aux;
		this.size++;
	}

	// troca n1 e n2 de posição na lista. não é permitido trocar os valores
	// guardados nos nós, só manipular as referências (prev/next). esse
	// algoritmo deve ser O(1), já que os nós a trocar são recebidos como
	// parâmetro (ou seja, não é permitido percorrer a lista para achá-los).
	public void swap(Node n1, Node n2) {
		if(n1 == null || n2 == null || n1 == n2) return;
		
		Node p1 = n1.prev, x1 = n1.next;
		Node p2 = n2.prev, x2 = n2.next;
		if(x1 == n2) {
			n2.prev = p1;
			n2.next = n1;
			n1.prev = n2;
			n1.next = x2;
			if(p1 != null) p1.next = n2;
			if(x2 != null) x2.prev = n1;
		} else if(x2 == n1) {
			n1.prev = p2;
			n1.next = n2;
			n2.prev = n1;
			n2.next = x1;
			if(p2 != null) p2.next = n1;
			if(x1 != null) x1.prev = n2;
		} else {
			n1.prev = p2;
			n1.next = x2;
			n2.prev = p1;
			n2.next = x1;
			if(p1 != null) p1.next = n2;
			if(x1 != null) x1.prev = n2;
			if(p2 != null) p2.next = n1;
			if(x2 != null) x2.prev = n1;
		}
		if(n1 == this.head) this.head = n2;
		else if(n2 == this.head) this.head = n1;
		
		if(n1 == this.tail) this.tail = n2;
		else if(n2 == this.tail) this.tail = n1;
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
		int remocoes = 0;
		int idx = 0;
		Node aux = this.head;
		while(aux != null) {
			if(aux.value == valor) {
				if(idx == 0) removeFirst();
				else if(idx == this.size - 1) removeLast();
				else {
					aux.prev.next = aux.next;
					aux.next.prev = aux.prev;
					this.size--;
				}
				remocoes++;
			} else {
				idx++;
			}
			aux = aux.next;
		}
		return remocoes;
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
