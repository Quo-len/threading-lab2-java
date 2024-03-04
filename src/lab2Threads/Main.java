package lab2Threads;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		  System.out.print("Num of threads: ");
		  Scanner scan = new Scanner(System.in); 
		  int numOfThreads = scan.nextInt();
		  System.out.print("Num of elements: ");
		  scan = new Scanner(System.in); 
		  int arraySize = scan.nextInt();
		  
		  ArrayOperations operation = new ArrayOperations(arraySize, numOfThreads);
		  operation.initializeArray();
		  operation.setRandomMin();
		  
		  operation.findMinElementParallel();
	}
}
