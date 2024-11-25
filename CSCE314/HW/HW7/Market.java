
/* Written by Hyunyoung Lee for CSCE 314 Students Homework 7 Problem 2 

   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: Stack Overflow, GeeksforGeeks, Classnotes
*/

import java.util.*;

/**
 * The Market class represents a market that holds a stock of items of type T.
 * It provides methods to sell items to the market and buy items from the market.
 *
 * @param <T> the type of items in the market
 */
public class Market<T> {
  List<T> stock; // stock of the market

  /**
   * Constructs a new Market object.
   * Initializes the stock as a new LinkedList of type T.
   */
  public Market() { stock = new java.util.LinkedList<T>(); }

  /**
   * Adds the specified item to the stock.
   *
   * @param item the item to be added to the stock
   */
  void sell(T item) {
    stock.add(item);
  }

  /**
   * Buys an item from the market.
   *
   * This method retrieves and removes the next item from the stock if available.
   * If the stock is empty, it throws an IllegalStateException.
   *
   * @return the next item from the stock
   * @throws IllegalStateException if the market is sold out
   */
  public T buy() {
    Iterator<T> iterator = stock.iterator();
    if (iterator.hasNext()) {
      T item = iterator.next();
      iterator.remove();
      return item;
    }
    throw new IllegalStateException("Market is sold out!");
  }

  /**
   * Sells a collection of items by adding them to the stock.
   *
   * @param items the collection of items to be sold, which can be of any type that extends T
   */
  void sell(Collection<? extends T> items) { // modify the parameter type
    stock.addAll(items);
  }


  /**
   * Buys a specified number of items from the stock and adds them to the given collection.
   *
   * @param n the number of items to buy
   * @param items the collection to which the bought items will be added
   * @throws IllegalStateException if there are not enough items in stock
   */
  void buy(int n, Collection<? super T> items) { // modify the parameter type
    if (stock.size() < n) {
      throw new IllegalStateException("Not enough items in stock!");
    }
    Iterator<T> iterator = stock.iterator();
    for (int i = 0; i < n; i++) {
      if (iterator.hasNext()) {
        items.add(iterator.next());
        iterator.remove();
      }
    }
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

