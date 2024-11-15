
/*   
   CellList.java skeleton written by Hyunyoung Lee
   For CSCE 314 [Sections 598, 599] Fall 2024, Assignment 6 Problem 4

   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: StackOverflow, GeeksForGeeks, ClassNotes
*/

import java.util.Arrays;
import java.util.Iterator;

// Total 40 points for the CellList class

public class CellList<E> implements Iterable<E>, Cloneable, Comparable<CellList<E>> {   
  private Cell<E> n;
  private int length;

  @Override
  public Iterator<E> iterator() { return n.iterator(); }

  // Task 1: override clone() (5 points)
    //
  @Override
  public CellList<E> clone() {
      // Create a new instance of CellList to hold the cloned elements
    CellList<E> clonedList = new CellList<>();

    // Use a for-each loop to iterate over the elements of the current list
    for (E item : this) {
        // Push the value of the current item to the cloned list
        clonedList.push(item);
    }

    // Return the cloned list
    return clonedList;
  } 

	 @Override
  public int compareTo(CellList<E> list) { 
    if (this.length < list.length) return -1;
    if (this.length == list.length) return 0;
    return 1; 
  }

  // Task 2: override equals() (10 points) 
	 @Override
  public boolean equals(Object o) {
         if (this == o) return true; // Check if both references are the same
         if (o == null || getClass() != o.getClass()) return false; // Check for null or different classes

         CellList<?> other = (CellList<?>) o;

         // Check if the lists are the same length
         if (this.length != other.length) return false;

         // Convert to arrays, sort, and compare elements
         Object[] thisArray = this.toArray();
         Object[] otherArray = other.toArray();

         Arrays.sort(thisArray);
         Arrays.sort(otherArray);

         // Compare the sorted arrays
         return Arrays.equals(thisArray, otherArray);
  }

    private Object[] toArray() {
        Object[] array = new Object[length]; // Create an array of the same length as the list
        int index = 0; // Initialize an index variable to keep track of the current position in the array
        for (E element : this) { 
            array[index++] = element; // Add the current element to the array and increment the index
        }
        return array; // Return the array
    }

  @Override
  public int hashCode() {
    return length; 
  }

  // no-arg constructor - given
  public CellList() { n = null; length = 0; }
    
  // Task 3: one-arg constructor (5 points)
  public CellList(Iterable<E> iterable) {
		// implement this constructor
      this(); // Call the no-arg constructor to initialize the list
      for (E item : iterable) {
        this.push(item); // Push each item from the iterable to the list
      }
  }

				
  // Task 4: total 20 points for toString(), push() and pop()
  // 8 points
    /**
     * Returns a string representation of the CellList.
     * The string representation consists of a list of the elements in the CellList
     * in the order they are returned by its iterator, enclosed in square brackets ("[]").
     * Each element is represented by its string representation as defined by the Cell's getVal() method.
     * The head of the list is specially marked with the label "(head: )".
     *
     * @return a string representation of the CellList
     */
  public String toString() {
      StringBuilder sb = new StringBuilder(); // Create a StringBuilder to build the string
      sb.append("["); // Add the opening bracket
      Cell<E> current = n; // Initialize a current Cell to the head of the list
      if (current != null) {
          sb.append("(head: ").append(current.getVal()).append(")"); // Add the head of the list
          current = current.getNext(); // Move to the next element
      }
      else {
          sb.append("(head: )"); // If the list is empty, add an empty head
          }
      while (current != null) {
          sb.append(" -> (").append(current.getVal()).append(")"); // Add the current element
          current = current.getNext(); // Move to the next element
      }
      sb.append("]"); // Add the closing bracket
      return sb.toString(); // Return the string
  }

  // 5 points
  public void push(E item) {
      // implement this method
      Cell<E> newCell = new Cell<E>(item, null); // Create a new Cell with the given item
      if (n == null) { 
          n = newCell; // If the list is empty, set the new Cell as the head
      } else {
          Cell<E> current = n; // Initialize a current Cell to the head of the list
          while (current.getNext() != null) {  
              current = current.getNext(); // Move to the last element
          }
          current.setNext(newCell); // Set the new Cell as the next element of the last element
      }
      length++; // Increment the length of the list

  }

    // 7 points
    public E pop() {
        // implement this method
        if (n == null) {
            return null; // If the list is empty, return null
        } else {
            E val = n.getVal(); // Get the value of the head of the list
            n = n.getNext(); // Move the head to the next element
            length--; // Decrement the length of the list
            return val; // Return the value of the head
        }
    }


  // given 
  public E peek() { return n.getVal(); }

  // given 
  public int getLength() { return length; }
}

