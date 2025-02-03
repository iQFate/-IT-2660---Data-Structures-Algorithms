//import java.util.*;
/*
 * IT-2660 - Lab 1
 * Student Name: Timothy Lenzer
 */

 public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world!");
    //array of numbers
    int [] numbers = {5,9,3,12,7,3,11,5};
    int length = numbers.length;
    Lab1 lab = new Lab1();
    //"Not sure why this line of code was part of the project but i left it intact".
    System.out.println(lab.increment(1));
//array in order using a while loop
System.out.println("Array in order using a while loop");
    int k = 0;
    while (k < length ){
      System.out.print(numbers[k] + " ");
      k++;
    }
    System.out.println();
//numbers in reverse using for loop
System.out.println("Numbers in reverse using for loop");
    for(int i = length - 1; i>=0; i--) {
       System.out.print(numbers[i] + " "); 
    }
    System.out.println();
    //Output the first and last values of the array.
    System.out.println("Output the first value of the array: " + numbers[0]);
    System.out.println("Output the last value of the array: " + numbers[length-1]);


// Call the methods created in Lab1.
    System.out.println("Sum of array: " + lab.sum(numbers));
    System.out.println("Average of array using foreach loop: " + lab.average(numbers));
    System.out.println("Max value: " + lab.max(numbers));
    System.out.println("Min value: " + lab.min(numbers));
  }
}     

// Add all of the methods here
class Lab1 {
  //Again not sure why its included but i left it alone.
  public int increment(int num) {
    return ++num;
  }
  //if statement for max value
  public int max (int[] nums){
    if (nums == null || nums.length != 7) {
    }

    int Valmax = nums[0];

    if (nums[1] > Valmax) {
      Valmax = nums[1];
    }
    if (nums[2] > Valmax){
      Valmax = nums[2];
    }
    if (nums[3] > Valmax){
      Valmax = nums[3];
    }
    if (nums[4] > Valmax){
      Valmax = nums[4];
    }
    if (nums[5] > Valmax){
      Valmax = nums[5];
    }
    if (nums[6] > Valmax){
      Valmax = nums[6];
    }
    if (nums[7] > Valmax){
      Valmax = nums[7];
    }
    return Valmax;
  }
//if statement for min value
  public int min (int[] nums){
    if (nums == null || nums.length != 7) {
    }

    int Valmin = nums[0];

    if (nums[1] < Valmin) {
      Valmin = nums[1];
    }
    if (nums[2] < Valmin){
      Valmin = nums[2];
    }
    if (nums[3] < Valmin){
      Valmin = nums[3];
    }
    if (nums[4] < Valmin){
      Valmin = nums[4];
    }
    if (nums[5] < Valmin){
      Valmin = nums[5];
    }
    if (nums[6] < Valmin){
      Valmin = nums[6];
    }
    if (nums[7] < Valmin){
      Valmin = nums[7];
    }
    return Valmin;
  }
  //For returning the sum of array. I used a for loop because specific method was not specified.
  public int sum (int[] nums){
    int total =0;
    for (int i =0; i < nums.length; i++) {
      total += nums[i];
    }
    return total;
  }
  //foreach loop to return the average.
  public double average (int[] nums){
    double total =0;
    for (int i : nums){
      total += i;
    }
      return (double) total / nums.length;
    }
  }

  
