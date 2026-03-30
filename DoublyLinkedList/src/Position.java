/**
 * @author Thabang Mamoloko
 */

/**
 * Interface for position of an element in a list
 */
public interface Position<E> {
	/**
	 * This method returns the element stored at this position
	 * @return the stored element
	 * @throws IllegalStateException
	 */
	E getElement() throws IllegalStateException;

}
