package lab2Threads;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		  Scanner scan = new Scanner(System.in); 
		  int numOfThreads = scan.nextInt();
		  
		  ArrayOperations operation = new ArrayOperations(100_000_000, numOfThreads);
		  operation.initializeArray();
		  operation.setRandomMin();
		  
		  operation.findMinElementParallel();
		  operation.findMinElement();
	}
}
