
/* Written by Hyunyoung Lee for CSCE 314 Students Homework 7 Problem 1

   Student Name: Shouro Shuvit
   UIN: 231007248
   Acknowledgements: Stack Overflow, GeeksforGeeks, Classnotes
*/

===================
=====   Part 1   ======
===================

=== Problem 2



=== Problem 3
To compile and run SimMain
Compile:
javac SimBox.java SimMain.java

Run:
java SimMain

Example Output:
From Homer to Marge: My doctor said don't walk.
From Marge to Homer: That was a traffic signal!
From Bart to Homer: There’s a 4:30 in the morning now?
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Bart to Homer: flooding the message queue...
From Homer to Bart: D'oh!

The output is different everytime because the thread execution timing can depend from run to run.


===================
=====   Part 2   ======
===================
Wildcards are meant to allow flexibility in generic programming. They enable operations on collections without requiring an exact match of types.
For instance, "? extends T:" Accepts a collection containing elements of type T or its subclasses and "? super T:" Accepts a collection containing
elements of type T or its superclasses. Wildcards allow for multiparameter inputs to preserve type safety. 

If we look at problem 2, 
With Wildcards:
public void sell(Collection<? extends T> items) {
    stock.addAll(items);
}
Will allow for selling a "Collection<Apple>" into a "Market<Fruit>"

Without Wildcards:
public void sell(Collection<T> items) {
    stock.addAll(items);
}
Would cause a compilation error if a Collection<Apple> was passed into a Market<Fruit>. 

===================
=====   Part 3   ======
===================
In Problem 3, synchronizing message queues is crucial to ensure that messages are processed in the correct order and without loss or duplication. In the example messaging scenarios provided in SimMain, multiple threads may be producing and consuming messages concurrently. Without synchronization, race conditions could occur, leading to inconsistent states where messages might be overwritten, lost, or processed multiple times. 

My implementation avoids the possibility of deadlock by carefully designing the locking strategy. Specifically, it ensures that locks are always acquired and released in a consistent order. Additionally, the implementation uses non-blocking synchronization techniques where possible, such as try-locks, to prevent threads from waiting indefinitely for a resource. By avoiding circular wait conditions and ensuring that all locks are released promptly after the critical section is executed, the implementation guarantees that deadlock cannot occur.





