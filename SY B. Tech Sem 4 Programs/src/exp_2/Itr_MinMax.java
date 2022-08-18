package exp_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Itr_MinMax {
	
	static int[] minmax(int length, int a[], int mm[]) {
		
		mm[0] = mm[1] = a[1];
		for(int i = 2;i<length;i++) {
			
			if(a[i]>mm[1]) {
				
				mm[1] = a[i];
			}
			
			if(a[i]<mm[0]) {
				
				mm[0] = a[i];
			}
		}
		return mm;
	}

	public static void main(String[] args) {

		int a[] = null, i, mm[] = new int[2];
		System.out.print("Enter the number of elements in array : ");
		Scanner s = new Scanner(System.in);
		try {
			
			a = new int[s.nextInt()];
		}
		catch(InputMismatchException e) {
			
			System.out.println("Enter a positive integer number");
			System.exit(0);
		}
		
		System.out.print("Enter the array : ");
		
		try {
			
			for(i=0;i<a.length;i++) {
				
				a[i] = s.nextInt();
			}
		}
		catch(InputMismatchException e) {
			
			System.out.println("Enter a positive integer number");
			System.exit(0);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.print("Enter the integer numbers equal to "+a.length);
			System.exit(0);
		}
		
		mm = minmax(a.length, a, mm);
		System.out.print("The maximum value is "+ mm[1] +" and minimum value is "+ mm[0]);
	}

}
