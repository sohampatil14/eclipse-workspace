package exp_1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Insertion_Recursive {

	static void print(int arr[]) {
		
		for(int k=0;k<arr.length;k++) {
			
			System.out.print(arr[k]+" ");
		}
		
		System.out.println();
	}
	
	static void insertion_sort(int arr[], int n) {
		
        if (n<=1) {
        	
        	System.out.print("Pass "+(n-1)+" : ");
        	print(arr);
        	return;
        }
        insertion_sort(arr,n-1);
        int end = arr[n-1];
        int i = n-2;

        while(i>=0 && arr[i]>end) {
        	
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = end;
        System.out.print("Pass "+(n-1)+" : ");
        print(arr);
        if(n==arr.length) {

        	System.out.println();
        	System.out.print("Sorted array : ");
        	print(arr);
        }
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
		
		insertion_sort(arr, arr.length);		
	}
}
