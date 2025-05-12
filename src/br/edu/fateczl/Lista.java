package  br.edu.fateczl;

import java.util.NoSuchElementException;

public class Lista<T> implements ILista<T>{
	
	No<T> primeiro;
	private int size;
	
	public Lista() {
		primeiro = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return primeiro == null;
	}

	@Override
	public int size() {
		return size;
	}
		

	@Override
	public void addFirst(T dado) {
		No<T> elemento = new No<>();
		elemento.dado = dado;
		elemento.proximo = primeiro;
		primeiro = elemento;
		size++;
	}

	@Override
	public void addLast(T dado) throws Exception {
		No<T> elemento = new No<>();
		elemento.dado = dado;
		if(isEmpty()) {
			primeiro = elemento;
		}else {
			No<T> ultimo = getNo(size() - 1);
			ultimo.proximo = elemento;
		}
		size++;
	}

	@Override
	public void add(T dado, int index) throws Exception {
		
		if(index < 0 || index > size()) throw new Exception("Índice inválido");
		
		if(index == 0) {
			addFirst(dado);
			return;
		}else if(index == size()) {
			addLast(dado);
			return;
		}else {
			No<T> elemento = new No<>();
			elemento.dado = dado;
			No<T> anterior = getNo(index-1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
			size++;
		}
		
	}

	@Override
	public void removeFirst() throws Exception {
		validarListaVazia();
		primeiro = primeiro.proximo;
		size--;
	}

	@Override
	public void removeLast() throws Exception {
		validarListaVazia();
		if(size() == 1) {
			removeFirst();
			return;
		}else {
			No<T> penultimo = getNo(size() - 2);
			penultimo.proximo = null;
			size--;
		}
		
	}

	@Override
	public void remove(int index) throws Exception {
		validarIndex(index);
		if(index == 0) {
			removeFirst();
			return;
		}else if(index == size() - 1) {
			removeLast();
			return;
		}else {
			No<T> anterior = getNo(index - 1);
			anterior.proximo = anterior.proximo.proximo;
			size--;
		}
	}

	@Override
	public T get(int index) throws Exception {
		No<T> elemento = getNo(index);
		return elemento.dado;
	}
	
	private No<T> getNo(int index) throws Exception{
		validarIndex(index);
		No<T> aux = primeiro;
		for(int i = 0; i < index; i++) {
			aux = aux.proximo;
		}
		return aux;
		
	}
	
	private void validarIndex(int index) throws Exception{
		validarListaVazia();
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException("Índice inválido");
	}
	
	private void validarListaVazia() throws Exception{
		if(isEmpty()) throw new NoSuchElementException("Lista vazia");
	}

	@Override
	public void clean() throws Exception {
		if(isEmpty()) throw new NoSuchElementException("Lista vazia");
		
		size = 0;
		primeiro = null;
		
	}
	
}
