//CSCE 312: Lab-1 Problem-5 framework
// This is version-2; bugfix for timediff
/* ***   README   **** */
/*This file is a framework: i.e. there is no actual code whose execution time will be
  measured. You need to populate the appropriate functions with the code that you wrote
  for the previous problems in order to get useful data.

  Turning in this file without your code will result in zero points being awarded for this problem.

  run this file as: gcc FileName.c -o ExecutableName -lrt

*/




#include <stdio.h>
#include <time.h>

// Macro definitions to ensure portablity between both sun.cs and linux.cs

#if defined(sun)
#define CLOCKNAME CLOCK_HIGHRES

#else
#define CLOCKNAME CLOCK_PROCESS_CPUTIME_ID
#endif

unsigned int input = 0;
unsigned int output = 0;

// Extract relevant sensor input bits using bit-masking
unsigned int driver_on_seat;
unsigned int driver_seat_belt_fastened;
unsigned int engine_running;
unsigned int doors_closed;
unsigned int key_in_car;
unsigned int door_lock_lever;
unsigned int brake_pedal;
unsigned int car_moving;

unsigned int bell = 0;
unsigned int dla = 0;
unsigned int ba = 0;

//The code segment which implements the decision logic
static inline void control_action(){
    output = 0;

    unsigned int DSBF = input & 1;    // Bit 0
    unsigned int ER = (input >> 1) & 1; // Bit 1
    unsigned int DC = (input >> 2) & 1; // Bit 2
    unsigned int DLC = (input >> 3) & 1; // Bit 3
    unsigned int DOS = (input >> 4) & 1; // Bit 4
    unsigned int KIC = (input >> 5) & 1; // Bit 5
    unsigned int BP = (input >> 6) & 1; // Bit 6
    unsigned int CM = (input >> 7) & 1; // Bit 7
    
    // BELL logic: Sounds if driver starts engine without fastening seatbelt or if doors are not closed
    if (ER && !DSBF) {
        output |= 1; // Set BELL (bit 0)
    } else if (ER && !DC) {
        output |= 1; // Set BELL (bit 0)
    }

    // DLA logic: Locks doors if driver is on seat and door lock lever is activated, or if keys are not in car
    if (DOS && DLC && DC) {
        output |= 2; // Set DLA (bit 1)
    } else if (!KIC && !DOS && !DLC) {
        output &= ~2; // Clear DLA (bit 1)
    }

    // BA logic: Engages brakes if brake pedal is pressed and car is moving
    if (BP && CM) {
        output |= 4; // Set BA (bit 2)
    }


}


static inline void read_inputs_from_ip_if(){

    //place your input code here
    //to read the current state of the available sensors

    input = 245;
    output = 0;

    control_action();

    if (output & 1)
        bell = 1;
    if (output & 2)
	    dla = 1;
    if (output & 4)
        ba = 1;
}

static inline void write_output_to_op_if(){
    //place your output code here
    //to display/print the state of the 3 actuators (DLA/BELL/BA)
    printf("bell = %d\n", bell);
    printf("door_lock_actu = %d\n", dla);
    printf("brake_actu = %d\n", ba);
}


/* ---     You should not have to modify anything below this line ---------*/

/*timespec diff from
http://www.guyrutenberg.com/2007/09/22/profiling-code-using-clock_gettime/
*/
struct timespec diff(struct timespec start, struct timespec end)
{
    struct timespec temp;
    //the if condition handles time stamp end being smaller than than
    //time stamp start which could lead to negative time.

    if ((end.tv_nsec-start.tv_nsec)<0) {
        temp.tv_sec = end.tv_sec-start.tv_sec-1;
        temp.tv_nsec = 1000000000+end.tv_nsec-start.tv_nsec;
    } else {
        temp.tv_sec = end.tv_sec-start.tv_sec;
        temp.tv_nsec = end.tv_nsec-start.tv_nsec;
    }
    return temp;
}

int main(int argc, char *argv[])
{
    unsigned int cpu_mhz;
    unsigned long long int begin_time, end_time;
    struct timespec timeDiff,timeres;
    struct timespec time1, time2, calibrationTime;

    clock_gettime(CLOCKNAME, &time1);
    clock_gettime(CLOCKNAME, &time2);
    calibrationTime = diff(time1,time2); //calibration for overhead of the function calls
    clock_getres(CLOCKNAME, &timeres);  // get the clock resolution data

    read_inputs_from_ip_if(); // get the sensor inputs

    clock_gettime(CLOCKNAME, &time1); // get current time
    control_action();                 // process the sensors
    clock_gettime(CLOCKNAME, &time2);   // get current time

    write_output_to_op_if();    // output the values of the actuators

    timeDiff = diff(time1,time2); // compute the time difference

    printf("Timer Resolution = %u nanoseconds \n ",timeres.tv_nsec);
    printf("Calibrartion time = %u seconds and %u nanoseconds \n ", calibrationTime.tv_sec, calibrationTime.tv_nsec);
    printf("The measured code took %u seconds and ", timeDiff.tv_sec - calibrationTime.tv_sec);
    printf(" %u nano seconds to run \n", timeDiff.tv_nsec - calibrationTime.tv_nsec);

    return 0;
}
