package exp_1;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Sort_Compare {

	static void insertion_sort(int arr[]) {
		
		int i, j, key;
		long start = System.nanoTime();
		
		for(i=0;i<arr.length;i++) {
			
			key = arr[i];
			j = i-1;
			
			while(j>=0 && arr[j]>key) {
				
				arr[j+1] = arr[j];
				j--;
 			}
			arr[j+1] = key;
		}
		
		long end = System.nanoTime();
		System.out.println("Time taken by Insertion sort for "+arr.length+" input is : " + (end - start) + " nanoseconds.");
	}
	
	static void selection_sort(int arr[]) {
		
		int i, j, min_index;
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
	public static void main(String args[]) {
		
		int arr[] = null;
		System.out.print("Enter the number of elements for sorting : ");
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		try {
			
			arr = new int[s.nextInt()];
		}
		catch(InputMismatchException e) {
			
			System.out.print("Enter an integer number.");
			System.exit(0);
		}
		for(int i=0;i<arr.length;i++) {
			
			arr[i] = r.nextInt(100000);
		}
		
		insertion_sort(arr);
		selection_sort(arr);
	}
}
