#include <stdio.h>
int main() {
    int j,k;
    j = 5;
    k = 10;
    for (int i=0; i <5; i++) {
        j = i*2;
        k = j+1;
    }
    printf("j = %d, k = %d\n", j, k);
}