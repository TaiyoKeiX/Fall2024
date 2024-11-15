
/* CellTest.java skeleton written by Hyunyoung Lee 
   CSCE 314 [Sections 598, 599] Fall 2024  
   Assignment 6 Problem 3 Test class 
   class CellTest

   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: StackOverflow, GeeksForGeeks, ClassNotes
*/

public class CellTest {

  // 15 points for the three methods: int_sum, num_sum, print
  // implement int_sum
  public static int int_sum(Cell<Integer> list) {
    if (list == null) return 0; // base case
    return list.getVal() + int_sum(list.getNext()); // recursive case
  }
  // implement num_sum
  public static double num_sum(Cell<? extends Number> list) {
    if (list == null) return 0; // base case
    return list.getVal().doubleValue() + num_sum(list.getNext()); // recursive case
  }
  // implement print
  public static void print(Cell<? extends Number> list) {
    if (list == null) return; // base case
    System.out.print(list.getVal() + " "); // print the current value
    print(list.getNext()); // recursive case
  }

	
  // Feel free to "expand" the main method but do not delete whatever provided 
  public static void main (String args[]) {
    Cell<Integer> intlist = 
        new Cell<Integer>(1, 
          new Cell<Integer>(22, 
            new Cell<Integer>(21, 
              new Cell<Integer>(12, 
                new Cell<Integer>(24, 
                  new Cell<Integer>(17, null))))));
        
    Cell<Integer> nullintlist = null;

    System.out.println("===");
    print(intlist);
    System.out.println();
    System.out.println("sum of intlist is " + int_sum(intlist));
    System.out.println("sum of null list is " + int_sum(nullintlist));
    System.out.println("===");

    Cell<Double> doublelist = 
        new Cell<Double>(1., 
          new Cell<Double>(16., 
            new Cell<Double>(13.72, 
              new Cell<Double>(5., 
                new Cell<Double>(22., 
                  new Cell<Double>(7.1, null))))));

    System.out.println("===");
    print(doublelist);
    System.out.println();
    System.out.println("sum ints = " + num_sum(intlist));
    System.out.println("sum doubles = " + num_sum(doublelist));
    System.out.println("===");
  }
}

