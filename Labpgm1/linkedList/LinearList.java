package linearList;
public interface LinearList<T>
{
	public int size();
	public boolean isEmpty();
	public void checkIndex(int index) throws IndexOutOfBoundsException;
	public T get(int index);
	public int indexOf(T element);
	public void add(T element, int index);
	public void remove(T element);
	public String toString();
}
