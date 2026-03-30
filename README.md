# Positional Lists
* In Array Lists, indeces provide an excellent means for describing the location of an element, or the location at which insertion and deletion of an element should take place.
* The downside of this is that, numeric indices are not a good choice for describing positions within a linked list because, knowing only an element's index, the only way to reach it is to traverse the list incrementally from its beginning or end, counting elements along the way.
* Indeces are not a good abstraction for describing a more local view of a position in a sequence, because the index of an entry changes over time due to insertions or deletions that happen earlier in the sequence.
* Out goal is therefore, to design an ADT that provides a user a way to refer to elements anywhere in a sequence, and perform arbitrary insertions and deletions.
* As we design a Positional List, we certainly have a linked list in mind, ensuring that our positional list takes the best advantage of particular capabilities of a linked list such as $O(1)$ time for insertions and deletions at arbitrary positions.
  * This is not possible with an array-based sequence.
* To achieve constant time insertions and deletions at arbitrary positions, we effectively need a reference to the node at which an element is stored.
* It is therefore very tempting to develp an ADT in which a node reference serves as the mechanism for describing a position.
* Unfortunately, the public use of nodes in the ADT woulf violate the OOD principles of abstraction and encapsulation.
* Therefore, in defining the postional list ADT, we also introduce the concept of a <b>Position</b>, which formalizes the intuitive notion of the "location" of an element relative to others in the list.

## Positions
* To provide a general abstraction for the location of an element within a structure, we define a simple position ADT.
* A position supports the following single method: <code>getElement() // Returns the element stored at this position</code>
* A position $p$ associated with some element $e$ in a list $L$, does not change, even if the index $e$ changes in $L$ due to insertions and deletions elsewhere in the list.
* The only way in which the postion becomes invalid is if that position is explicitly removed from the list.

## The Positional List ADT
* This is a collection of positions, each of which stores an element.
* The accessor methods provided by the positional list ADT include the following for a list $L$:
  - <code>first() // Returns the position of the first element of L</code>
  - <code>last() // Returns the positions of the lat element of L</code>
  - <code>before(p) // Returns the position of L immediately before position p</code>
  - <code>after(p) // Returns the position of L immediately after position p</code>
  - <code>isEmpty() // Returns true if listL does not contain any elements</code>
  - <code>size() // Returns the number of elements in list L</code>
* An error occurs if a position $p$, sent as a parementer to a method, is not a valid position for the list.
* Updated Metods of a Postional List:
  - <code>addFirst(e) // Inserts a new element e at the front of the list, returning the position of a new element</code>
  - <code>addLast(e) // Inserts a new element e at the back of the list, returning the position of the new element</code>
  - <code>addBefore(p, e) // Inserts a new element e in the list, just before position p, returning the position of the new element</code>
  - <code>addAfter(p, e) /*/ Inserts a new element e in the list, just after the postion p, returing the position of the new element</code>
  - <code>set(p, e) // Replaces the element at a position p with a new element e, returning the element formerly at position p</code>
  - <code>remove(p) // Removes and returns the element at position p in the list, invalidating the position</code>

* 📁Project Folder: [DoublyLinkedList](https://github.com/thabang-m-modiba/PositionalLists/tree/f7f78814da70f4939081db900e7bcc90711b93b4/DoublyLinkedList)
