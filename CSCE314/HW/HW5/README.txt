
Title: Homework 5 README

## First, write your name, UIN, and acknowledge any help received 
## in doing this assignment

Student Name: Shouro Shuvit
UIN: 231007248
Acknowledgements: Stack Overflow, Class Notes, GeeksforGeeks

## Also, state which version of Java on which machine you used to  
## compile and run your programs
java version "23.0.1" 2024-10-15
Java(TM) SE Runtime Environment (build 23.0.1+11-39)
Java HotSpot(TM) 64-Bit Server VM (build 23.0.1+11-39, mixed mode, sharing)
Intel i7-8700k, 32gb Ram, Windows 11 (local machine)

----------
Problem 2
----------
Compilation CMD: javac SubsetOutputFib.java
Code Execution CMD: java SubsetOutputFib Int1 Int2
If Int1 is 4 and Int2 is 7 then the output is:
4: 3
5: 5
6: 8 *
7: 13
Where even Fibonacci numbers are denoted with an *. 
The two ints are the indexes of the fibbonacci sequence will start and end at. 
A good way to test the program would be with:
java SubsetOutputFib 5 8
Which would yield:
5: 5
6: 8 *
7: 13
8: 21 *
And to test the error handling a test case would be 
java SubsetOutputFib 7 4
Which would yield 
Input error: Swapping the values to ensure be <= en.
4: 3
5: 5
6: 8 *
7: 13
Which is a good way to handle the error without breaking the system. 

----------
Problem 3
----------
Compilation CMD: javac ImprovedFibonacci.java
Code Execution CMD: java ImprovedFibonacci
Output:
1: 1
2: 1
3: 2 *
4: 3
5: 5
6: 8 *
7: 13
8: 21
9: 34 *
Where even Fibonacci numbers are denoted with an *. 
The function of the program is to provide for the first 9 elements of the fibbonacci sequence
and the put an asterisk on the elements that are even. 
The only way to test this would be to have the fibbonacci sequence to check for accuracy. 


----------
Problem 4
----------
Compilation CMD: javac Vehicle.java
Code Execution CMD: java Vehicle
Output (when used with other classes):
Vehicle ID: 1
Owner: No Owner
Current Speed: 0.0 km/h
Current Direction: 0.0 degrees

Vehicle ID: 2
Owner: Alice
Current Speed: 60.0 km/h
Current Direction: 45.0 degrees
The functionality of the class is to create a constructor for the Vehicle and to provide for all the getters and setters to run VehicleTest as well as a display functionality. 
The way to test this to use the functions in the next part to verify the setters and getters. 


----------
Problem 5
----------
Compilation CMD: javac Vehicle.java VehicleTest.java
Code Execution CMD: VehicleTest
Output (when used with other classes):
Vehicle Information:
Owner: Owner 1, Speed: 50.0, Direction: 0.0
Vehicle Information:
Owner: Owner 2, Speed: 60.0, Direction: 45.0
Vehicle Information:
Owner: Owner 3, Speed: 70.0, Direction: 90.0
Vehicle Information:
Owner: Owner 4, Speed: 80.0, Direction: 135.0
Vehicle Information:
Owner: Owner 5, Speed: 90.0, Direction: 180.0
Vehicle Information:
Owner: Owner 6, Speed: 75.0, Direction: 150.0
Vehicle Information:
Owner: Owner 7, Speed: 70.0, Direction: 180.0
Vehicle Information:
Owner: Owner 8, Speed: 65.0, Direction: 210.0
Vehicle Information:
Owner: Owner 9, Speed: 60.0, Direction: 240.0
Vehicle Information:
Owner: Owner 10, Speed: 55.0, Direction: 270.0
The purpose of the class is to provide for the base functionality of the rest of the program by implementing the dataset that we will be manipulated for the other problems.
The way to test the class is to verify that the previous problems constructors are working by checking if input and output values match. 


----------
Problem 6
----------
Compilation CMD: javac Vehicle.java VehicleTest.java
Code Execution CMD: VehicleTest
Output (when used with other classes): 
Any of the output of the class should be functional if the toString function is working. 
The test would be to see if any of the functions are not working due to the toString's errors. 


----------
Problem 7
----------
Compilation CMD: javac Vehicle.java VehicleTest.java
Code Execution CMD: VehicleTest
Output (when used with other classes):
--- Changing Vehicle Speeds ---

--- Vehicle Information After Speed Change ---
Vehicle Information:
Owner: Owner 1, Speed: 120.0, Direction: 0.0

Vehicle Information:
Owner: Owner 2, Speed: 60.0, Direction: 45.0

...

Vehicle Information:
Owner: Owner 10, Speed: 60.0, Direction: 270.0

--- Stopping All Vehicles ---

--- Vehicle Information After Stopping ---
Vehicle Information:
Owner: Owner 1, Speed: 0.0, Direction: 0.0

Vehicle Information:
Owner: Owner 2, Speed: 0.0, Direction: 45.0

...
The purpose of the code is to provide information and change the speed of the cars on a case to case basis as well as stop the cars and update all the information at will. 
The way to test the class is to verify that the previous problems constructors are working by checking if input and output values match. Also to check if the stop method will set the speed to 0. 

----------
Problem 8
----------
Compilation CMD: javac Vehicle.java VehicleTest.java
Code Execution CMD: VehicleTest
Output (when used with other classes):
--- Turning by Degrees ---
Turned vehicle 1 by 90 degrees
Turned vehicle 2 by -45 degrees

--- After Turning by Degrees ---
Vehicle ID: 1, Owner: Owner 1, Speed: 50.0, Direction: 90.0
Vehicle ID: 2, Owner: Owner 2, Speed: 60.0, Direction: 0.0

--- Turning Using Constants ---
Turned vehicle 3 left (-90 degrees)
Turned vehicle 4 right (90 degrees)

--- After Turning Using Constants ---
Vehicle ID: 3, Owner: Owner 3, Speed: 70.0, Direction: 0.0
Vehicle ID: 4, Owner: Owner 4, Speed: 80.0, Direction: 225.0
The prupose of the code is to provide intormation and change the direction of the cars on a case to case basis as well as using TURN_LEFT and TURN_RIGHT to turn cars 90 degrees counterclockwise and clockwise respectively. 
The way to test the class is to verify that the previous problems constructors are working by checking if input and output values match as well as the directions for the Turns to mathc. 

...


----------
Problem 9
----------
Compilation CMD: javac Vehicle.java PassengerVehicle.java
Code Execution CMD: java PassengerVehicle
Output (when used with other classes):
--- Original Passenger Vehicles Information ---
Vehicle ID: 1, Owner: Alice, Total Seats: 7, Occupied Seats: 2, Available Seats: 5
Vehicle ID: 2, Owner: Bob, Total Seats: 5, Occupied Seats: 1, Available Seats: 4
Vehicle ID: 3, Owner: Charlie, Total Seats: 12, Occupied Seats: 8, Available Seats: 4
Vehicle ID: 4, Owner: Dave, Total Seats: 4, Occupied Seats: 3, Available Seats: 1
Vehicle ID: 5, Owner: Eve, Total Seats: 10, Occupied Seats: 5, Available Seats: 5

--- Passenger Vehicles After Sorting by Total Seats in Descending Order ---
Vehicle ID: 3, Owner: Charlie, Total Seats: 12, Occupied Seats: 8, Available Seats: 4
Vehicle ID: 5, Owner: Eve, Total Seats: 10, Occupied Seats: 5, Available Seats: 5
Vehicle ID: 1, Owner: Alice, Total Seats: 7, Occupied Seats: 2, Available Seats: 5
Vehicle ID: 2, Owner: Bob, Total Seats: 5, Occupied Seats: 1, Available Seats: 4
Vehicle ID: 4, Owner: Dave, Total Seats: 4, Occupied Seats: 3, Available Seats: 1
The purpose of the class is to provide information and change seating of the respective vehicles when needed
The way to test the class is to verify that the previous problems constructors are working by checking if input and output values match.

## End of README

