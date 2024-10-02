#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <sys/time.h>

struct employee1 {
    int id;
    char name[50];
};

struct employee2 {
    int id;
    char name[52];
};



int main() {
    FILE *output_file = fopen("lab1_prob2_out.txt", "w");
    if (output_file == NULL) {
        printf("Error opening output file.\n");
        return 1;
    }

    fprintf(output_file, "The sizes of different data type for this machine and compiler are -\n");
    
    fprintf(output_file, "int data type is %lu bytes or %lu bits long\n", sizeof(int) * 8, sizeof(int));
    fprintf(output_file, "unsigned int data type is %lu bytes or %lu bits long\n", sizeof(unsigned int) * 8, sizeof(unsigned int));
    fprintf(output_file, "double data type is %lu bytes or %lu bits long\n", sizeof(double) * 8, sizeof(double));
    fprintf(output_file, "long data type is %lu bytes or %lu bits long\n", sizeof(long) * 8, sizeof(long));
    fprintf(output_file, "long long data type is %lu bytes or %lu bits long\n", sizeof(long long) * 8, sizeof(long long));
    fprintf(output_file, "char data type is %lu bytes or %lu bits long\n", sizeof(char) * 8, sizeof(char));
    fprintf(output_file, "float data type is %lu bytes or %lu bits long\n", sizeof(float) * 8, sizeof(float));
    fprintf(output_file, "struct timeval data type is %lu bytes or %lu bits long\n", sizeof(struct timeval) * 8, sizeof(struct timeval));
    fprintf(output_file, "short data type is %lu bytes or %lu bits long\n", sizeof(short) * 8, sizeof(short));
    fprintf(output_file, "FILE* data type is %lu bytes or %lu bits long\n", sizeof(FILE*) * 8, sizeof(FILE*));

    printf("The sizes of different data type for this machine and compiler are -\n");
    printf("int data type is %ld bytes or %ld bits long\n",sizeof(int), sizeof(int)*8); 
    printf("unsigned int data type is %ld bytes or %ld bits long\n",sizeof(unsigned int), sizeof(unsigned int)*8); 
    printf("double data type is %ld bytes or %ld bits long\n",sizeof(double), sizeof(double)*8);
    printf("long data type is %ld bytes or %ld bits long\n",sizeof(long), sizeof(long)*8);
    printf("long long data type is %ld bytes or %ld bits long\n",sizeof(long long), sizeof(long long)*8);
    printf("char data type is %ld bytes or %ld bits long\n",sizeof(char), sizeof(char)*8);
    printf("float data type is %ld bytes or %ld bits long\n",sizeof(float), sizeof(float)*8);
    printf("struct timeval data type is %ld bytes or %ld bits long\n",sizeof(struct timeval), sizeof(struct timeval)*8);
    printf("short data type is %ld bytes or %ld bits long\n",sizeof(short), sizeof(short)*8);
    printf("FILE* data type is %ld bytes or %ld bits long\n",sizeof(FILE*), sizeof(FILE*)*8);
    printf("Size of struct employee1: %lu bytes\n", sizeof(struct employee1));
    printf("Size of struct employee2: %lu bytes\n", sizeof(struct employee2));

    fclose(output_file);
    

    printf("Output file generated successfully.\n");

    return 0;
}