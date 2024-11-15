
/* Cell.java skeleton written by Hyunyoung Lee
   For CSCE 314 [Sections 598, 599] Fall 2024, Assignment 6 Problem 3 

   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: StackOverflow, GeeksForGeeks, ClassNotes
*/

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

// class Cell: 10 points
// give correct class header - given in the problem statement
public final class Cell<E> implements Iterable<E>{ // modify this header
  // private fields
		private E elem; // stores a value of type E
		private Cell<E> next; // link to the next Cell

  // constructor
        public Cell (E elem, Cell<E> next) {
            this.elem = elem; // set the value of the current cell
            this.next = next; // set the next cell
        }

  // iterator() returns a CellIterator object for this object
      /**
       * Returns an iterator over elements of type {@code E}.
       *
       * @return a {@code CellIterator<E>} instance that can be used to iterate over the elements in this cell.
       */
      @Override
      public CellIterator<E> iterator() {
            return new CellIterator<>(this);
      }

      // getter and setter methods for the private fields
      public E getVal() {
          return elem;
        }
      public void setVal(E v) {
          this.elem = v;
      }
      public Cell<E> getNext() {
            return next;
      }
      public void setNext(Cell<E> node) {
          this.next = node;
      }

  // CellIterator: 20 points
  // Having CellIterator as an inner class of Cell makes sense...
  // (2 points) correct class header - given in the problem statement
  class CellIterator<E> implements Iterator<E> { // modify this header
    private Cell<E> p;  // given

    // (3 points) constructor
    public CellIterator (Cell<E> n) {
        this.p = n;
    }

      // (5+10=15 points) two methods to implement the Iterator interface
    // (5 points) hasNext()
    @Override
    public boolean hasNext() {
        return p != null; // if p is not null, there is a next element
    }

    // (10 points) next()
    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException(); // if there is no next element, throw an exception
        }
        E elem = p.getVal(); // get the value of the current cell
        p = p.getNext(); // move to the next cell
        return elem; // return the value of the current cell
    }



  } // end of CellIterator
} // end of Cell




