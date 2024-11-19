
/* Written by Hyunyoung Lee for CSCE 314 Students Homework 7 Problem 2 

   Student Name:
   UIN:
   Acknowledgements:
*/

import java.util.*;

public class Market<T> {
  List<T> stock; // stock of the market

  public Market() { stock = new java.util.LinkedList<T>(); }

  void sell(T item) {
    // implement this method
    
  }
  public T buy() {
    // implement this method
  }
  void sell(List<T> items) { // modify the parameter type
    // implement this method
  }
  void buy(int n, List<T> items) { // modify the parameter type
    // implement this method
  }
} // end of class Market


// Study class Main. You don't need to modify class Main
class Main {
  // three static nested classes expressing example subclass hierarchy
  // Gala <: Apple <: Fruit
  static class Fruit { public String toString () { return "Fruit"; } }
  static class Apple extends Fruit {
                       public String toString () { return "Apple"; }
  }
  static class Gala extends Apple {
                       public String toString () { return "Gala"; }
  }

  public static void main(String args[]) {
    Market<Fruit> farmersmarket = new Market<Fruit> ();

    Deque<Fruit> fruits = new ArrayDeque<Fruit>();
    fruits.addFirst(new Gala());
    fruits.addFirst(new Apple());
    //Fruit a = fruits.remove();
    //if (a instanceof Apple) System.out.println("a is Apple");

    Vector<Apple> apples = new Vector<Apple>();
    apples.addElement(new Apple());
    apples.addElement(new Apple());
    apples.addElement(new Gala());

    farmersmarket.sell(fruits);
    farmersmarket.sell(apples);
    farmersmarket.sell(new Fruit());
    farmersmarket.sell(new Gala());

    ArrayList<Fruit> mybasket = new ArrayList<Fruit>();

    farmersmarket.buy(6, mybasket);

    // print out what you bought
    System.out.println("Here's what I bought");
    for (Fruit e : mybasket) System.out.println(e);
    System.out.println("Enjoy!");
  } // end of main
} // end of class Main

