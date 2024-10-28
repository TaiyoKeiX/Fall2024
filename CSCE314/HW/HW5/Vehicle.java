
/* CSCE 314 [Sections 598, 599] Programming Languages, Fall 2024
   Homework Assignment 5 
   Skeleton for Problems 4-9
   Written by Hyunyoung Lee for CSCE 314 Students

   Student Name: Shouro Shuvit
   Student UIN:
   Acknowledgements: Stack Overflow, Class Notes, GeeksforGeeksb 
*/

import java.util.*; // for Collections.sort() and ArrayList

class Vehicle { //Problem4
    // Private static field to hold the next available vehicle ID
    private static int nextVehicleID = 1;

    // Private field to hold the unique ID of this vehicle
    private final int vehicleID;

    // Private fields for speed, direction, and owner name
    private double currentSpeed;
    private double currentDirection;
    private String ownerName;

    // No-argument constructor
    public Vehicle() {
      this.vehicleID = nextVehicleID++;  // Assign unique ID
      this.ownerName = "";  // Default to an empty string if owner isn't set
    }

    // One-argument constructor to initialize the owner name
    public Vehicle(String owner) {
      this();  // Call the no-arg constructor to assign an ID
      this.ownerName = owner;
    }

    // Getter for vehicle ID (no setter as IDs are immutable)
    public int getVehicleID() {
      return vehicleID;
    }

    // Getter and setter for current speed
    public double getCurrentSpeed() {
      return currentSpeed;
    }

    public void setCurrentSpeed(double speed) {
      this.currentSpeed = speed;
    }

    // Getter and setter for current direction
    public double getCurrentDirection() {
      return currentDirection;
    }

    public void setCurrentDirection(double direction) {
      this.currentDirection = direction;
    }

    // Getter and setter for owner name (as a string)
    public String getOwnerName() {
      return ownerName;
    }

    public void setOwnerName(String owner) {
      this.ownerName = owner;
    }

    // Method to display the vehicle’s information
    public void displayInfo() {
      System.out.println("Vehicle ID: " + vehicleID);
      System.out.println("Owner: " + (ownerName.isEmpty() ? "No Owner" : ownerName));
      System.out.println("Current Speed: " + currentSpeed + " km/h");
      System.out.println("Current Direction: " + currentDirection + " degrees");
    }
}



class VehicleTest {
    // Constants for turning
    public static final int TURN_LEFT = -90;
    public static final int TURN_RIGHT = 90;

    // Static method in VehicleTest to find the highest vehicle ID
    public static int getHighestVehicleID(Vehicle[] vehicles) {
      int highestID = Integer.MIN_VALUE;
      for (Vehicle v : vehicles) {
        if (v.getVehicleID() > highestID) {
          highestID = v.getVehicleID();
        }
      }
      return highestID;
    }

    // Static method to convert a Vehicle object to a string representation
    public static String vehicleToString(Vehicle v) {
        return "Vehicle ID: " + v.getVehicleID() +
                ", Owner: " + (v.getOwnerName().isEmpty() ? "No Owner" : v.getOwnerName()) +
                ", Speed: " + v.getCurrentSpeed() + " km/h" +
                ", Direction: " + v.getCurrentDirection() + " degrees";
    }

    // Static method to change the speed of a given vehicle
    public static void changeSpeed(Vehicle vehicle, double newSpeed) {
        System.out.println("Changing speed of Vehicle ID " + vehicle.getVehicleID() +
                " to " + newSpeed + " km/h.");
        vehicle.setCurrentSpeed(newSpeed);
    }

    // Static method to stop a given vehicle by setting its speed to 0
    public static void stop(Vehicle vehicle) {
        System.out.println("Stopping Vehicle ID " + vehicle.getVehicleID() + ".");
        vehicle.setCurrentSpeed(0);
    }

    // Static method to turn a vehicle by a specific number of degrees
    public static void turnByDegrees(Vehicle vehicle, double degrees) {
        System.out.println("Turning Vehicle ID " + vehicle.getVehicleID() + " by " + degrees + " degrees.");
        vehicle.setCurrentDirection(vehicle.getCurrentDirection() + degrees);
    }

    // Static method to turn a vehicle using predefined constants
    public static void turnUsingConstant(Vehicle vehicle, int directionConstant) {
        System.out.println("Turning Vehicle ID " + vehicle.getVehicleID() +
                " by " + directionConstant + " degrees.");
        vehicle.setCurrentDirection(vehicle.getCurrentDirection() + directionConstant);
    }


    public static void main(String[] args) {
        // Array to store 10 vehicles
        Vehicle[] vehicles = new Vehicle[10];

        // Create the first 5 vehicles using the no-arg constructor and set fields using setters
        for (int i = 0; i < 5; i++) {
          vehicles[i] = new Vehicle();  // No-arg constructor
          vehicles[i].setOwnerName("Owner " + (i + 1));  // Set owner name
          vehicles[i].setCurrentSpeed(50 + i * 10);  // Speed: 50, 60, 70, ...
          vehicles[i].setCurrentDirection(i * 45);   // Direction: 0, 45, 90, ...
        }

        // Create the next 5 vehicles using the one-arg constructor (owner name)
        for (int i = 5; i < 10; i++) {
          vehicles[i] = new Vehicle("Owner " + (i + 1));
          vehicles[i].setCurrentSpeed(100 - i * 5);  // Speed: 75, 70, 65, ...
          vehicles[i].setCurrentDirection(i * 30);   // Direction: 150, 180, ...
        }

        // Change the speed of some vehicles using changeSpeed
        System.out.println("--- Changing Vehicle Speeds ---");
        changeSpeed(vehicles[0], 120);  // Change speed of vehicle 1 to 120
        changeSpeed(vehicles[9], 60);   // Change speed of vehicle 10 to 60

        // Display information again after speed change
        System.out.println("\n--- Vehicle Information After Speed Change ---");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }

        // Stop all vehicles using the stop method
        System.out.println("--- Stopping All Vehicles ---");
        for (Vehicle v : vehicles) {
            stop(v);  // Stop each vehicle by setting speed to 0
        }

        // Display information after stopping all vehicles
        System.out.println("\n--- Vehicle Information After Stopping ---");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }

        // Test turning by degrees
        System.out.println("--- Turning by Degrees ---");
        turnByDegrees(vehicles[0], 90);  // Turn 90 degrees
        turnByDegrees(vehicles[1], -45); // Turn -45 degrees

        // Display information after turning by degrees
        System.out.println("\n--- After Turning by Degrees ---");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }

        // Test turning using constants
        System.out.println("--- Turning Using Constants ---");
        turnUsingConstant(vehicles[2], TURN_LEFT);  // Turn left (-90 degrees)
        turnUsingConstant(vehicles[3], TURN_RIGHT); // Turn right (90 degrees)

        // Display information after turning using constants
        System.out.println("\n--- After Turning Using Constants ---");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }


        // Find and print the highest vehicle ID used so far
        int highestID = getHighestVehicleID(vehicles);
        System.out.println("\nHighest Vehicle ID used so far: " + highestID);

        for (Vehicle v : vehicles) {
            System.out.println("\n" + vehicleToString(v));  // Use custom toString logic
        }

    }
}

  // Hints on the PassengerVehicle class for Problem 9 of Homework 4
  class PassengerVehicle extends Vehicle
          implements Comparable<PassengerVehicle> {
        // private fields specific to PassengerVehicle such as
        // total # of seats and occupied seats (both can be of type int,
        // and properly initialized)
      private int totalSeats;
      private int occupiedSeats;


      /* constructors: Give three constructors,
         1. one no-arg constructor,
         2. a constructor with one argument: only owner name as an argument,
         3. a constructor with two arguments: owner name and total # of seats

         Probably you already have the first two constructors in the Vehicle
         class, then, invoke the Vehicle class constructor by using `super`
      */
      public PassengerVehicle() {
          super();  // Calls the no-arg constructor of Vehicle
          this.totalSeats = 0;
          this.occupiedSeats = 0;
      }

      public PassengerVehicle(String owner) {
          super(owner);  // Calls the one-arg constructor of Vehicle
          this.totalSeats = 0;
          this.occupiedSeats = 0;
      }

      public PassengerVehicle(String owner, int totalSeats) {
          super(owner);  // Calls the one-arg constructor of Vehicle
          this.totalSeats = totalSeats;
          this.occupiedSeats = 0;
      }

        /* get methods for the private fields */
        public int getTotalSeats() {
            return totalSeats;
        }

      public int getOccupiedSeats() {
          return occupiedSeats;
      }

      public int getAvailableSeats() {
          return totalSeats - occupiedSeats;
      }

      /* set methods for the private fields */

      public void setTotalSeats(int totalSeats) {
          this.totalSeats = totalSeats;
      }

      public void setOccupiedSeats(int occupiedSeats) {
          if (occupiedSeats >= 0 && occupiedSeats <= totalSeats) {
              System.out.println("Setting occupied seats to: " + occupiedSeats); // Debug message
              this.occupiedSeats = occupiedSeats;  // Assign the correct value
          } else {
              System.out.println("Error: Invalid number of occupied seats!");  // Error message
          }
      }

        // override the toString method (inherited from the Object class)
        // signature: toString()
        // @Override
        // ...
      @Override
      public String toString() {
          return "PassengerVehicle{" +
                  "Owner='" + getOwnerName() + '\'' +
                  ", Speed=" + getCurrentSpeed() +
                  ", Direction=" + getCurrentDirection() +
                  ", Total Seats=" + totalSeats +
                  ", Occupied Seats=" + occupiedSeats +
                  ", Available Seats=" + getAvailableSeats() +
                  '}';
        }

        // implement compareTo method (to `implements` Comparable)
        // signature: compareTo(PassengerVehicle)

        // main method
        public static void main(String[] args) {
          // You can use either the basic Java array [] (and use Arrays.sort)
          // or ArrayList
          // (or any Collections, whichever you feel the easiest)
          // Using ArrayList, you would do something like,
          ArrayList<PassengerVehicle> pVs = new ArrayList<PassengerVehicle>();
          // where pVs is object reference for ArrayList of PassengerVehicles
            // Add at least 5 PassengerVehicle objects with varying seats
          pVs.add(new PassengerVehicle("Alice", 10));
          pVs.add(new PassengerVehicle("Bob", 20));
          pVs.add(new PassengerVehicle("Charlie", 15));
          pVs.add(new PassengerVehicle("Diana", 5));
          pVs.add(new PassengerVehicle("Eve", 30));
          // Now, you can add PassengerVehicle objects (at least 5) to pVs
          // e.g., pVs.add( new PassengerVehicle("H Lee", 7) );
          // which addes a PassengerVehicle object with
          // owner name "H Lee" and total 7 seats

          Collections.sort(pVs); // Sort the PassengerVehicles
          // in an ascending order according to
          // the compareTo method implementation

          // Find a way to output the ascending sorted result in descending
          // order. Use a for loop to print out the sorted result
          // in a descending order
          System.out.println("--- Passenger Vehicles in Descending Order by Total Seats ---");
          for (int i = pVs.size() - 1; i >= 0; i--) {
              System.out.println(pVs.get(i));
          }

          System.out.println("\n--- Available Seats After Occupying More Seats ---");
          pVs.get(0).setOccupiedSeats(5);  // Occupy 5 seats in the first vehicle
          pVs.get(1).setOccupiedSeats(10); // Occupy 10 seats in the second vehicle
          for (PassengerVehicle v : pVs) {
              System.out.println("Vehicle owned by " + v.getOwnerName() +
                      " - Available Seats: " + v.getAvailableSeats());
          }

    } // end of main

    @Override
    public int compareTo(PassengerVehicle o) {
        return Integer.compare(this.totalSeats, o.totalSeats);
    }
  } // end of class PassengerVehicle


