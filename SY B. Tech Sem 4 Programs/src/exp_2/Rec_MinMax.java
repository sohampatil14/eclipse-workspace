package exp_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rec_MinMax {
	
	static int[] minmax(int low, int high, int a[], int mm[]) {
		
		if(low==high) {
			
			mm[0] = a[low];
			mm[1] = a[high];
			System.out.print("Sub-array : ");
			for(int i=low;i<=high;i++) {
				
				System.out.print(a[i]+" ");
			}
			for(int i=0;i<3;i++) {
				
				System.out.print('\t');
			}
			System.out.print("Range : "+low+" to : "+high+'\t'+"Min : "+mm[0]+" Max : "+mm[1]+'\n');
			return mm;	
		}
		
		else if((high-low)==1) {
			
			if (a[low]<a[high]) {
            	
            	mm[0] = a[low];
                mm[1] = a[high];
            }
            
            else {
            	
            	mm[0] = a[high];
                mm[1] = a[low];
            }
			System.out.print("Sub-array : ");
			for(int i=low;i<=high;i++) {
				
				System.out.print(a[i]+" ");
			}
			int i = 0;
			while(i<2) {

				System.out.print('\t');
				i++;
			}
			System.out.print("Range : "+low+" to : "+high+'\t'+"Min : "+mm[0]+" Max : "+mm[1]+'\n');
			return mm;			
		}
		
		else {
			
			int mm1[] = new int[2];
			mm1[0] = Integer.MAX_VALUE;
			mm1[1] = Integer.MIN_VALUE;	
			int mid = (low+high)/2;
			minmax(low,mid,a,mm);
			minmax(mid+1,high,a,mm1);
			if(mm[0]>mm1[0]) {
				
				mm[0] = mm1[0];
			}
			if(mm[1]<mm1[1]) {
				
				mm[1] = mm1[1];
			}
			System.out.print("Sub-array : ");
			for(int i=low;i<=high;i++) {
				
				System.out.print(a[i]+" ");
			}
			if((high-low)==(a.length-1)) {
				
				System.out.print('\t');
			}
			else {
				
				int i = 0;
				while(i<2) {

					System.out.print('\t');
					i++;
				}
			}
			System.out.print("Range : "+low+" to : "+high+'\t'+"Min : "+mm[0]+" Max : "+mm[1]+'\n');
			return mm;
		}
	}

	public static void main(String[] args) {

		int i, a[] = null;
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
		int mm[] = new int[2];
		mm[0] = Integer.MAX_VALUE;
		mm[1] = Integer.MIN_VALUE;	
		System.out.println();
		mm = minmax(0, a.length-1, a, mm);
		System.out.print("The maximum value is "+ mm[1] +" and minimum value is "+ mm[0]);
	}

}
