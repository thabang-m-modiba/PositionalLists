/**
 * @author Thabang Mamoloko
 */

/**
 * Interface for the functionality of the Positional List ADT
 */
public interface PositionalList<E> {
	/**
	 * Method to return the size of the list
	 * @return int size
	 */
	int size();
	
	
	/**
	 * Method to check is the list is empty or not
	 * @return true if empty, and false if not
	 */
	boolean isEmpty();
	
	
	/**
	 * Method to return the first Position of the list
	 * @return the first Position, or null if empty
	 */
	Position<E> first();
	
	
	/**
	 * Method to return the last Position of the list
	 * @return the last Position, or null if empty
	 */
	Position<E> last();
	
	
	/**
	 * Method to return the Position immediately before Position p
	 * @param p - Position after the targeted Position
	 * @return new Position
	 * @throws IllegalArgumentException
	 */
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	
	
	/**
	 * Method to return the Position immediately after Position p
	 * @param p - Position before the targeted Position
	 * @return new Position
	 * @throws IllegalArgumentException
	 */
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	
	
	/**
	 * The method to insert an element e at the front of the list and return its new Position
	 * @param e - The element to be inserted
	 * @return The new Position
	 */
	Position<E> addFirst(E e);
	
	
	/**
	 * The method to insert an element e at the back of the list and return its new Position
	 * @param e - The element to be inserted
	 * @return The new Position
	 */
	Position<E> addLast(E e);
	
	
	/**
	 * The method to insert an element e immediately before the Position p
	 * @param p - The Position after the targeted Position
	 * @param e - The element to be inserted
	 * @return the new Position
	 * @throws IllegalArgumentException
	 */
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	
	/**
	 * The method to insert an element e immediately after the Position p
	 * @param p - The Position before the targeted Position
	 * @param e - The element to be inserted
	 * @return the new Position
	 * @throws IllegalArgumentException
	 */
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	
	/**
	 * The method to replace the element stored at Position p and return the replace element
	 * @param p - The Position with an element to replace
	 * @param e - The new element
	 * @return The replace element
	 * @throws IllegalArgumentException
	 */
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	
	/**
	 * A method to remove Position p
	 * @param p - The Position to be removed
	 * @return The element of the removed Position
	 * @throws IllegalArgumentException
	 */
	E remove(Position<E> p) throws IllegalArgumentException;
}
