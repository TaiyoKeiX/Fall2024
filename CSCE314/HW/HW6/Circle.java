
/* Skeleton provided by Hyunyoung Lee
   For CSCE 314 [Sections 598, 599] Fall 2024, Assignment 6 Problem 2

   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: StackOverflow, GeeksForGeeks, ClassNotes
*/

class Circle extends Shape {
  private double radius;

  // constructor that accepts a Point (for position) and a double
  // (for the radius).
  public Circle(Point p0, double r)
  {
    super(p0); // call the superclass constructor
    this.radius = r; // set the radius
  }

  // implement equals(), hashCode(), area(), and toString()
  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true; // check if the objects are the same
    if (!(o instanceof Circle other)) return false; 
    return this.position.equals(other.position) && Double.compare(this.radius, other.radius) == 0; // check if the position and radius are the same

  }

  @Override
  public int hashCode()
  {
    return position.hashCode() * 31 + Double.hashCode(radius); // return the hashcode
  }

  @Override
  public double area()
  {
    return Math.PI * radius * radius; // return the area of the circle
  }

  @Override
  public String toString()
  {
    return "Circle[position=" + position + ", radius=" + radius + ", area=" + area() + "]"; // return the string representation of the circle
  }
} // end of class Circle

