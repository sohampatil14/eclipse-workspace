package exp_1;
import java.util.Random;
import java.util.Scanner;

public class Sort_Insertion {

	public static void main(String args[]) {
		
		int i, j, key, arr[];
		System.out.print("Enter the number of elements for sorting : ");
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		arr = new int[s.nextInt()];
		
		for(i=0;i<arr.length;i++) {
			
			arr[i] = r.nextInt(100000000);
		}
		
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
}
