package  br.edu.fateczl;

public interface ILista<T> {
	
	public boolean isEmpty();
	public int size();
	public void addFirst(T dado);
	public void addLast(T dado) throws Exception;
	public void add(T dado, int index) throws Exception;
	public void removeFirst() throws Exception;
	public void removeLast() throws Exception;
	public void remove(int index) throws Exception;
	public T get(int index) throws Exception;
	public void clean() throws Exception;
}
