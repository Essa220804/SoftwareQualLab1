package com.ontariotechu.sofe3980U;

import java.util.Scanner;

import org.joda.time.LocalTime;

/**
 * Hello world!
 *
 */
public class App 
{
	/**
	* Main program:  The entry point of the program. The local time will be printed first,
	*      Then it will create two binary variables, add them and print the result.
	*
	* @param args: not used
	*/
    public static void main( String[] args )
    {
		// LocalTime currentTime = new LocalTime();
		// System.out.println("The current local time is: " + currentTime);
		// Binary binary1=new Binary("00010001000");
        // System.out.println( "First binary number is "+binary1.getValue());
		// Binary binary2=new Binary("111000");
        // System.out.println( "Second binary number is "+binary2.getValue());
		// Binary sum= Binary.add(binary1,binary2);
		// System.out.println( "Their summation is "+sum.getValue());


		Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Binary Calculator!");
        
        System.out.println("Enter the first binary number: ");
        String binary1 = scanner.nextLine().trim();
        
        System.out.println("Enter the second binary number: ");
        String binary2 = scanner.nextLine().trim();

		System.out.println("What operation would you like to perform?: ");
		System.out.println("Enter 1 for OR");
		System.out.println("Enter 2 for AND");
		System.out.println("Enter 3 for MULTIPLY");

		int opChoice = scanner.nextInt();
        
		
		try {

			Binary b1 = new Binary(binary1);
            Binary b2 = new Binary(binary2);

			switch(opChoice){
				case 1:
					System.out.println("Performing bitwise OR...");
					System.out.println("Result: " + b1.or(b2));
					break;

				case 2:
					System.out.println("Performing bitwise AND...");
					System.out.println("Result: " + b1.and(b2));
					break;

				case 3:
					System.out.println("Performing multiplication...");
					System.out.println("Result: " + b1.multiply(b2));

				default:
					System.out.println("Did not enter a valid option, exiting...");

			}
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    
    }
}
