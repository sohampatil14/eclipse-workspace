package exp_1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Insertion {

	static void print(int arr[]) {
		
		for(int k=0;k<arr.length;k++) {
			
			System.out.print(arr[k]+" ");
		}
		System.out.println();
	}
	
	static void insertion_sort(int arr[]) {
		
		int i, j, key;
		for(i=0;i<arr.length;i++) {
			
			key = arr[i];
			j = i-1;
			
			while(j>=0 && arr[j]>key) {
				
				arr[j+1] = arr[j];
				j--;
 			}
			arr[j+1] = key;
			System.out.print("Pass "+i+" : ");
			print(arr);
		}
		System.out.print("Sorted array : ");
		print(arr);
	}
	
	public static void main(String args[]) {
		
		int arr[] = null;
		System.out.print("Enter the number of elements for sorting : ");
		Scanner s = new Scanner(System.in);
		try {
			
			arr = new int[s.nextInt()];
		}
		catch(InputMismatchException e) {
			
			System.out.print("Enter an integer number.");
			System.exit(0);
		}
		System.out.print("Enter the elements for sorting : ");
		try {

			for(int i=0;i<arr.length;i++) {
				
				arr[i] = s.nextInt();
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.print("Enter "+arr.length+" number of elements.");
			System.exit(0);
		}
		insertion_sort(arr);		
	}
}
