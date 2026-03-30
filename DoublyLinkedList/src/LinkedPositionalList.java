/**
 * @author Thabang Mamoloko
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class implements PositionlList interface
 * The LinkedPositionalList Class contains:
 *     The header node
 *     The trailer node
 *     The size of the list
 */
public class LinkedPositionalList<E> implements PositionalList<E>{
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	/**
	 * Construct a new empty list
	 */
	public LinkedPositionalList() {
		header = new Node<> (null, null, null);
		trailer = new Node<> (null, header, null);
		header.setNext(trailer);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Position<E> first() {
		// TODO Auto-generated method stub
		return position(header.getPrev());
	}

	@Override
	public Position<E> last() {
		// TODO Auto-generated method stub
		return position(trailer.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
 		return position(node.getPrev());
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
 		return position(node.getNext());
	}

	@Override
	public Position<E> addFirst(E e) {
		// TODO Auto-generated method stub
		return addBetween(e, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		// TODO Auto-generated method stub
		return addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}
	
	/**
	 * 
	 * @return
	 */
	public Iterable<Position<E>> positions(){
		return new PositionIterable();
	}
	public Iterator<E> iterator(){
		return new ElementIterator();
	}
	
	/**
	 * The method to valid Position
	 * @param p - Position to be validated 
	 * @return
	 * @throws IllegalArgumentException
	 */
	private Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node)) {
			throw new IllegalArgumentException("Invalid Position");
		}
		Node<E> node = (Node<E>) p;
		if(node.getNext() == null) {
			throw new IllegalArgumentException("Position us no longer in the list");
		}
		return node;
	}
	
	/**
	 * Method to return the given node as a Position, or null, if it is a sentinel
	 * @param node - The node of interest
	 * @return new Position?
	 */
	private Position<E> position(Node<E> node){
		if(node == header || node == trailer) {
			return null;
		}
		return node;
	}
	
	/**
	 * Method to add elements to the linked list between the given positions/ nodes
	 * @param e - The element to add
	 * @param pred - The left node
	 * @param succ - The right node
	 * @return new Position of the inserted element
	 */
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ){
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}
	
	/**
	 * The Position Iterator class
	 */
	private class PositionIterator implements Iterator<Position<E>>{
		private Position<E> cursor = first();
		private Position<E> recent = null;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor != null;
		}

		@Override
		public Position<E> next() throws NoSuchElementException{
			// TODO Auto-generated method stub
			if(cursor == null) {
				throw new NoSuchElementException("Nothing left");
			}
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		
		public void remove() throws IllegalStateException{
			if(recent == null) {
				throw new IllegalStateException("Nothing to remove");
			}
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}
		
	}
	
	/**
	 * The Position Iterable class
	 */
	private class PositionIterable implements Iterable<Position<E>>{

		@Override
		public Iterator<Position<E>> iterator() {
			// TODO Auto-generated method stub
			return new PositionIterator();
		}
		
	}
	
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = new PositionIterator();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return posIterator.hasNext();
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return posIterator.next().getElement();
		}
		 /**
		  * The remove method
		  */
		public void remove() {
			posIterator.remove();
		}
		
	}
	
	/**
	 * Method to print the list
	 */
	public void printList() {
		for(int i = 0; i < size; i++) {
			Node<E> currentNode = header;
			while(currentNode != null) {
				System.out.print(currentNode.getElement() + ", ");
			}
			System.out.println("END");
		}
	}
}
