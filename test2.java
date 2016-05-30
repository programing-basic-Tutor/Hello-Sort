import java.lang.*;
import java.io.*;

/**
	* Reference: Introduction to Java Programming Eighth Edition  Program 20-5
	*/


public class test2 {
	public static void main(String[] args) {
		
		/**PrintWriter outputfile = null;
		
		try {
			// Create a file
			outputfile = new PrintWriter("text.txt");
			
			// Write formatted output to the file
			outputfile.println("Welcome to Java");
		}
		catch  (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			// Close the file
			if (outputfile != null)
				outputfile.close();
		} */
		double[] a = {4, 6, 9, 8.2, 7.9, 10.3, 15.6};
		sort(a);
		
		for(int i = 0; i< a.length; i++){
			System.out.println(a[i]);
		}
	
		
		System.out.println("End of program");
	}
	
	public static void sort(double[] list) {
		sort(list, 0, list.length - 1);  // Sort the entire list
	}
	public static void sort(double[] list, int low, int high) {
		if (low < high) {
			// Find the smallest number and its index in list (low ... high)
			int indexOfMin = low;
			double min = list[low] ;
			for (int i = low + 1; i <= high; i++) {
				if (list[i] < min) {
					min = list[i];
					indexOfMin = i;
				}
			}
			// Swap the smallest in list(low ... high) with list(low)
			list[indexOfMin] = list[low];
			list[low] = min;
			
			// Sort the remaining list(low + 1 .. high)
			sort(list, low+1, high);
		}
	}
}

