/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalVersionsOfGrade12JavaProjects;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Filename: recursionlab.java
 * assignment: Recursion lab
 * Teacher: Mr. J.F
 * Course: ICS 4U1
 * @author vict0582
 * Name: Victor Jiang
 * Description: The goal of this lab is to get familiar with the process of recursion. This lab is
  broken into a two smaller tasks, rather than one larger task, #1, to create a recursive method that implements Fibonacci sequence
 * and to also create another algorithm that solves a problem recursively (the towers of hanoi problem is chosen)
 * due date: April 17, 2022
 */
public class FinalVersionRecursionLabof2023 {
    
    public static long fibonacci (long num){// the fibonacci sequece
        
        //base case
        if (num <= 1){// the first positions 0 and 1, in the sequece are 1, so when the method is called and the num is 1, return that
            return num;
        }
        else{
            // num -1 and minus 2 because each position in the sequece is simply the sum of the two preceding integers.
            return fibonacci(num-1) + fibonacci (num-2);// recursively calculates the "num-1th" and "num-2th" Fibonacci numbers, and returns their sum.
        }
    }
    
    public static int towersOfHanoi (int num, char from_rod, char to_rod, char aux_rod){
        // this method is the classic towers of hanoi problem
        // goal: to be able to shift all the disks from one rod to another (the end one) without stacking a bigger rod on top of a smaller one.
        //#1: only one disk can be moved at a time
        //#2: a larger disk cannot be placed on the top of a smaller disk
        // be able to check if ther are any existing disks to move in the first place
        //explanation: tobreak it down into seperate smaller problems
        // we can move the bottom disk from the starting rod to the next rod (destination), 
        // then we can be able to move the n-1 disks from the temporary "auxilary rod" to the desired destination rod but this time using 
        //using the starting rod as an auxiliary
        if (num == 0 ){
            return num;// be able to return the # of disks, to exit the method
        }
        else{
            //we want to move the top num-1 disks from the char "from rod" to the "aux rod" then "to rod" as the auxiliary. 
            // we do this so that before moving the bottom disk from "from rod" to "to rod"
            // we do num-1 as the # of disks 
            towersOfHanoi (num-1, from_rod, aux_rod, to_rod); // Move the top num-1 disks from the 'from_rod' to the 'aux_rod' using the 'to_rod' as the intermediate/temporary rod
            System.out.println("Move the disk " + num + " from rod " + from_rod + " to rod " + to_rod); // now we move the bottom-most disk from the 'from_rod' to the 'to_rod'
            towersOfHanoi (num - 1, aux_rod, to_rod, from_rod);// now we move the top num-1 disks from the 'aux_rod' to the 'to_rod' using the 'from_rod' as the temporary rod
        return num;
        }
    }
    
    public static void main (String []args){// main with error trapping
        boolean commence = false;
        do{// do loop for error trapping
            System.out.println("------------------------------------------------");// introduce program
            System.out.println("Hello and welcome the recursion program:");
            System.out.println("This program will have 3 main functions");
            System.out.println("You will have around 2 choices to choose from,");
            System.out.println("This program uses recursive methods in order to implement and solve problems");
            System.out.println();
            System.out.println("Fibonacci = Fibonacci where you can enter position of the number in the fibonacci sequence");
            System.out.println("and the program will display the correct number in the sequence");
            System.out.println("Tower = Towers of Hanoi problem, a classic problem that can be solved using recursion.");
            System.out.println("------------------------------------------------");
            System.out.println("User enters: ");

            Scanner sc = new Scanner(System.in);//import scanner
            String decision = sc.nextLine(); // take user input as a string

            switch (decision){// switch between user input
                case "Fibonacci":// case of user entering Fibonacci
                    boolean fibon = false;
                    System.out.println("Welcome to the fibonacci sequence, ");// introduce
                    do{// do loop to error trap
                        try{// try to get the correct user input, only in integer form
                            System.out.println("Please enter the position of the sequence you would like to see in integer format please:");// inform input
                            Scanner fib = new Scanner(System.in);
                            long seq = fib.nextLong();// set as a long
                                if (seq >=0 && seq<=40){// define parameters, because pst 40 the program does not have enough memory to do so, (takes forever to run)
                                    long fibResult = fibonacci(seq);
                                    System.out.println("The number at position " + seq + " in the Fibonacci sequence is " + fibResult);
                                    commence = true;
                                    break;
                                }else if (seq >40){
                                    System.out.println("The limit for the fibnacci sequence cannot display past position 40, sorry, the program takes to long to solve this recursively");
                                    fibon = false;
                                }
                                else{
                                    System.out.println("Invalid input: the position in the Fibonacci sequence must be a non-negative integer.");
                                    fibon = false;
                                }   
                            }   
                            catch (InputMismatchException e){
                                System.out.println("You entered not an integer, this is an invalid input, sorry. ");
                                fibon = false;
                            }
                    }while(fibon==false);
                    break;// break to prevent falltrough
                    
                case "Tower":// towers of hanoi method
                    boolean disk = false;
                    do{
                        try{
                            System.out.println("Please enter the number of disks and the problem will be solved");
                            Scanner tower = new Scanner(System.in);//scanner in
                            int numDisks = tower.nextInt();// scans for next integer
                            
                            if (numDisks <=0){// cannot be no disks, or else nothing to solve
                                System.out.println("You entered either a zero or negative integer, meaning there are zero disks to sort, or you can't have negative disks.");
                                System.out.println("So there is nothing to sort :] ");
                                disk = true;
                                break;
                            }
                            else if(numDisks > 0){// main case, happens when there are cases
                                towersOfHanoi(numDisks, 'A', 'C', 'B');// a is the starting tower, c is where we want it, and b is the "temporary" tower
                                commence = true;
                                break;
                            }
                        }//end of try
                        catch (InputMismatchException e){// catch if anything other than integer is inputed
                            System.out.println("You entered not an integer, this is an invalid input, sorry. ");
                            disk = false;
                        }
                }while(disk==false);
                break;// break to prevent fallthrough
                
                default:// the default case where initially the program does not receive a proper input not matching either two choices.
                    System.out.println("I did receive a proper input for which option to select,");
                    System.out.println("Please enter the one of the provided options in the correct format");
                    commence = false;
                    break;
          }// end of switch
        }while(commence==false);// end of do
    }//end of main
}// end of class
