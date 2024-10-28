
/* CSCE 314 [Sections 598, 599] Programming Languages, Fall 2024
   Homework Assignment 5
   Skeleton for Problems 2 & 3
   Written by Hyunyoung Lee for CSCE 314 Students

   Student Name: Shouro Shuvit
   Student UIN: 231007248
   Acknowledgements: Stack Overflow, Class Notes, GeeksforGeeks
*/
class SubsetOutputFib{ //Problem 2
    // Method to calculate the nth Fibonacci number iteratively
    public static long fibbonaci(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        // Ensure exactly two command-line arguments are provided
        if (args.length != 2) {
            System.out.println("Error: Please provide exactly two integer arguments.");
            return;
        }

        int be, en;

        try {
            // Parse the command-line arguments to integers
            be = Integer.parseInt(args[0]);
            en = Integer.parseInt(args[1]);

            // Convert both inputs to absolute values
            be = Math.abs(be);
            en = Math.abs(en);

            // Swap values if 'be' is greater than 'en'
            if (be > en) {
                System.out.println("Input error: Swapping the values to ensure be <= en.");
                int temp = be;
                be = en;
                en = temp;
            }

            // Print the Fibonacci numbers from f(be) to f(en)
            for (int i = be; i <= en; i++) {
                long fibNum = fibbonaci(i); // Compute the Fibonacci number
                System.out.print(i + ": " + fibNum); // Print the index and Fibonacci number
                if (fibNum % 2 == 0) { // Mark even numbers with '*'
                    System.out.print(" *");
                }
                System.out.println(); // New line after each output
            }

        } catch (NumberFormatException e) {
            // Handle cases where the inputs are not valid integers
            System.out.println("Error: Both inputs must be valid integers.");
        }
    }
}



class ImprovedFibonacci { // Problem 3
    // Inner class to hold the Fibonacci value and its even/odd status
    private static class FibonacciEntry {
        long value;     // Stores the Fibonacci number
        boolean isEven; // Indicates if the value is even

        // Constructor to initialize the value and its even status
        FibonacciEntry(long value) {
            this.value = value;
            this.isEven = (value % 2 == 0);
        }

        // String representation for easy printing
        @Override
        public String toString() {
            return value + (isEven ? " *" : "");
        }
    }

    // Method to calculate the nth Fibonacci number iteratively
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        final int MAX_INDEX = 9; // Maximum index for the Fibonacci sequence

        // Array to hold the Fibonacci sequence as FibonacciEntry objects
        FibonacciEntry[] fibonacciSequence = new FibonacciEntry[MAX_INDEX];

        // Populate the array with Fibonacci numbers and their even/odd status
        for (int i = 0; i < MAX_INDEX; i++) {
            long fibValue = fibonacci(i); // Calculate the Fibonacci value
            fibonacciSequence[i] = new FibonacciEntry(fibValue); // Store in the array
        }

        // Print the Fibonacci sequence along with the even/odd markers
        for (int i = 0; i < MAX_INDEX; i++) {
            System.out.println((i + 1) + ": " + fibonacciSequence[i]);
        }
    }
}
