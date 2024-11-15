
/* Skeleton provided by Hyunyoung Lee
   For CSCE 314 [Sections 598, 599] Fall 2024, Assignment 6 Problem 2

   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: StackOverflow, GeeksForGeeks, ClassNotes
*/

public final class Point {
  public double x;
  public double y;

  // constructor that sets the values of x and y
  public Point(double x, double y)
  { 
    this.x = x; // set x
    this.y = y; // set y
  } 

  // implement equals, hashCode(), toString()
  @Override
  public boolean equals(Object s)
  {
    if (this == s) return true; // check if the objects are the same
    if (!(s instanceof Point other)) return false; 
    return this.x == other.x && this.y == other.y; // check if the x and y values are the same
  }

  @Override
  public int hashCode()
  {
    return (int) (31.0 * x + y); // return the hashcode
  }

  @Override
  public String toString()
  {
    return "(" + x + ", " + y + ")"; // return the string representation of the point
  }
} // end of class Point

