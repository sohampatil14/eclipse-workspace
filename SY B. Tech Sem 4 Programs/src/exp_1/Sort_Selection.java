package exp_1;

import java.util.Random;
import java.util.Scanner;
class Sort_Selection {
	
	public static void main(String args[]) {
		
		int i, j, min_index, arr[];
		System.out.print("Enter the number of elements for sorting : ");
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		arr = new int[s.nextInt()];
		for(i=0;i<arr.length;i++) {
			
			arr[i] = r.nextInt(100000000);
		}
		long start = System.nanoTime();
		for (i=0;i<arr.length-1;i++) {
			
			min_index = i;
			for (j=i+1;j<arr.length;j++) {
 
				if (arr[j] < arr[min_index]) {
					
					min_index = j;
				}
			}
 
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
 
		long end = System.nanoTime();
		System.out.println("Time taken by Selection sort for "+arr.length+" input is : " + (end - start) + " nanoseconds.");
	}
}