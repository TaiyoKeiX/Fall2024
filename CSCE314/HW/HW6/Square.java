
/* Skeleton provided by Hyunyoung Lee
   For CSCE 314 [Sections 598, 599] Fall 2024, Assignment 6 Problem 2

   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: StackOverflow, GeeksForGeeks, ClassNotes
*/

class Square extends Shape {
  private double side; // side is the side length

  // constructor that accepts a Point (for position) and a double
  // (for the side length).
  public Square(Point p0, double side) {
    super(p0); // call the superclass constructor
    this.side = side; // set the side length
  }

  // implement equals(), hashCode(), area(), and toString()
  @Override
  public boolean equals(Object o) {
    if (this == o) return true; // check if the objects are the same
    if (!(o instanceof Square other)) return false; 
    return this.position.equals(other.position) && Double.compare(this.side, other.side) == 0; // check if the position and side length are the same
  }

  @Override
  public int hashCode() {
    return position.hashCode() * 31 + Double.hashCode(side); // return the hashcode
  }

  @Override
  public double area() {
    return side * side; // return the area of the square
  }

  @Override
  public String toString() {
    return "Square[position=" + position + ", side=" + side + ", area=" + area() + "]"; // return the string representation of the square
  } // end of class Square
}

