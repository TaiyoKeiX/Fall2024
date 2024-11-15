
/* Skeleton provided by Hyunyoung Lee
   For CSCE 314 [Sections 598, 599] Fall 2024, Assignment 6 Problem 2
 
   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: StackOverflow, GeeksForGeeks, ClassNotes
*/

abstract class Shape implements Comparable<Shape> {
  public Point position;
  public double area;

  // constructor that sets position as the Point passed as an argument
  // signature: Shape (Point)
  // implement the constructor
  public Shape(Point position) {
    this.position = position; // set the position
  }

  // implement equals()
  @Override
  public boolean equals(Object o) {
    if (this == o) return true; // check if the objects are the same
    if (!(o instanceof Shape other)) return false; 
    return this.position.equals(other.position) && Double.compare(this.area(), other.area()) == 0; // check if the position and area are the same
  }

  // area() should be abstract
  public abstract double area();

  // implement compareTo()
  @Override
  public int compareTo(Shape s) {
    return Double.compare(this.area(), s.area()); // compare the areas of the shapes
  } // end of class Shape
}




