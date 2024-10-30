#include <stdio.h>

int very_fast_function(int i) {
    long result;  // Use long to match 64-bit size

    // Inline assembly to implement the logic
    __asm__ (
        "imulq $64, %[i], %[i]\n\t"  // i = i * 64
        "addq $1, %[i]\n\t"           // i = i + 1
        "cmpq $1024, %[i]\n\t"        // Compare (i * 64 + 1) > 1024
        "jle 1f\n\t"                  // If not greater, jump to label 1
        "movq %[orig_i], %[result]\n\t" // If greater, result = original i
        "jmp 2f\n"                    // Jump to end (label 2)
        "1:\n\t"                      // Label 1: if condition is false
        "movq $0, %[result]\n"        // result = 0
        "2:\n"                        // Label 2: end of function
        : [result] "=r" (result)      // Output operand
        : [i] "r" ((long)i), [orig_i] "r" ((long)i)  // Input operands
        : "cc"                        // Clobbered flags
    );

    return (int)result;  // Cast result back to int for return
}

int main(int argc, char *argv[]) {
    int i = 40;
    printf("The function value of i is %d\n", very_fast_function(i));
    return 0;
}
