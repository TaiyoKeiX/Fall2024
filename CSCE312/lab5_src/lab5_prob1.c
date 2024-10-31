#include <stdio.h>

int main() {
    int i,j;
    i = 5;
    j = 5;
    if (i <= j) {
        i= i+2;
    }
    else {
        i=1;
        j++;
    }
    printf("i = %d, j = %d\n", i, j);
}