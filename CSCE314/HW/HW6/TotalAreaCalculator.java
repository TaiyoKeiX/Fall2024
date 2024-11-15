
/* Skeleton provided by Hyunyoung Lee
   For CSCE 314 [Sections 598, 599] Fall 2024, Assignment 6 Problem 2
 
   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: StackOverflow, GeeksForGeeks, ClassNotes
*/

class TotalAreaCalculator {
  public static double calculate(Shape[] shapes) {
    double totalArea = 0.0; // initialize the total area to 0
    for (Shape shape : shapes) { 
      totalArea += shape.area(); // add the area of each shape to the total area
    }
    return totalArea; // return the total area
  }
}

