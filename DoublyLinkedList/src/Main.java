/**
 * @author Thabang Mamoloko
 */

/**
 * Class tests the implementation of the Positional List ADT
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedPositionalList<String> list = new LinkedPositionalList<>();
		
		Position<String> p1 = list.addFirst("A");
		Position<String> p2 = list.addAfter(p1, "B");
		//list.printList();
		list.addBefore(p2, "X");
		list.printList();
		
	}
	/**
	 * Fix the code so it doesn't print the list three times lol
	 */

}
