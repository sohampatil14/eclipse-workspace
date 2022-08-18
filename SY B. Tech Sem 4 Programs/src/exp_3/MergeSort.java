package exp_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSort {

	public static int[] mergeSort(int[] arr, int n) {
		
	    if(n<2) {
	    
	    	return null;
	    }
	    int mid = n/2;
	    int[] sub_l = new int[mid];
	    int[] sub_r = new int[n-mid];

	    for(int i=0;i<mid;i++) {
	        
	    	sub_l[i] = arr[i];
	    }
	    for(int i=mid;i<n;i++) {
	        
	    	sub_r[i-mid] = arr[i];
	    }
	    mergeSort(sub_l, mid);
	    mergeSort(sub_r, n - mid);
	    merge(arr, sub_l, sub_r, mid, n-mid);
	    return arr;	    
	}
	
	public static void merge(int[] arr, int[] sub_l, int[] sub_r, int left, int right) {
			 
		System.out.println("Merge sub-arrays - ");
		System.out.print("Left Sub-array: ");
		for(int control=0;control<=(sub_l.length-1);control++) {
		
			System.out.print(sub_l[control]+" ");
		}
		System.out.println();
		System.out.print("Right Sub-array: ");
		for(int control=0;control<=(sub_r.length-1);control++) {
		
			System.out.print(sub_r[control]+" ");
		}
			
		int i=0, j=0, k=0;
		while (i<left && j<right) {
		
			if (sub_l[i]<=sub_r[j]) {
			
				arr[k++] = sub_l[i++];
			 }
			else {
			
				arr[k++] = sub_r[j++];
			}
		}
		while (i<left) {
			        
			arr[k++] = sub_l[i++];
		}
		while (j<right) {
		
			arr[k++] = sub_r[j++];
		}
		System.out.println();
		System.out.print("Array after merging : ");
		for(int control=0;control<=(arr.length-1);control++) {
		
			System.out.print(arr[control]+" ");
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {


		  int data[] = null, i;
			System.out.print("Enter the number of elements in array : ");
			Scanner s = new Scanner(System.in);
			try {
				
				data = new int[s.nextInt()];
			}
			catch(InputMismatchException e) {
				
				System.out.println("Enter a positive integer number");
				System.exit(0);
			}
			
			System.out.print("Enter the array : ");
			
			try {
				
				for(i=0;i<data.length;i++) {
					
					data[i] = s.nextInt();
				}
			}
			catch(InputMismatchException e) {
				
				System.out.println("Enter a positive integer number");
				System.exit(0);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.print("Enter the integer numbers equal to "+data.length);
				System.exit(0);
			}
		    System.out.println();
		    System.out.println("Unsorted Array");
		    System.out.println();
	        System.out.println(java.util.Arrays.toString(data));
	        System.out.println();
		    int size = data.length;
			data = mergeSort(data, data.length);
		    System.out.println();
		    System.out.println("Sorted Array in Ascending Order ");
		    System.out.println();
		    System.out.println(java.util.Arrays.toString(data));

	}
	
}



