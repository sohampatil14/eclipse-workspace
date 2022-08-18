package exp_2;

import java.util.InputMismatchException;
import java.util.Scanner;

class Itr_Binary {

	static int binarySearch(int arr[], int x) {
		
		int low = 0, high = arr.length - 1;
		while (low<=high) {
		
			int mid = low+(high-low)/2;
			if (arr[mid]==x) {
				
				return mid;
			}
			if (arr[mid]<x) {
				
				low = mid + 1;
			}
			else {
				
				high = mid - 1;
			}
		}

		return -1;
	}

    static int[] selection_sort(int arr[]) {
        
    	int i, j, min_index;
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
		print(arr);
		return arr;
    }
    
    static void print(int arr[]) {
        
    	System.out.print("Sorted Array : ");
        for (int i=0; i<arr.length; ++i) {
        	
        	System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
	
	public static void main(String args[]) {
		
		int arr[] = null, i, result = 0, j = 0, k = 0, r1, r2, flag = 0, count = 0;
		System.out.print("Enter the number of elements in array : ");
		Scanner s = new Scanner(System.in);
		
		try {
			
			arr = new int[s.nextInt()];
		}
		catch(InputMismatchException e) {
			
			System.out.println("Enter a positive integer number");
			System.exit(0);
		}
		
		System.out.print("Enter the array : ");
		
		try {
			
			for(i=0;i<arr.length;i++) {
				
				arr[i] = s.nextInt();
			}
		}
		catch(InputMismatchException e) {
			
			System.out.println("Enter a positive integer number");
			System.exit(0);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.print("Enter the integer numbers equal to "+arr.length);
			System.exit(0);
		}
		
		arr = selection_sort(arr);
		
		System.out.print("Enter the number to search : ");
		
		try {
			
			result = binarySearch(arr, s.nextInt());
		}
		catch(InputMismatchException e) {
			
			System.out.println("Enter a positive integer number");
			System.exit(0);
		}
		try {
			
			for(i=(result+1);i<arr.length;i++) {
				
				if(arr[i]==arr[result]) {
					
					j++;
				}
			}
			
			for(i=(result-1);i>=0;i--) {
				
				if(arr[i]==arr[result]) {
					
					k++;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {

		}
		if (result == -1) {
			
			System.out.println("Element not present");
		}
		else {
			
			r1 = r2 = result;
			System.out.println("Element found at index(es) ");
			if(j>=1) {
				
				while(j>=0) {
					
					System.out.println(r1);
					j--;
					r1++;
				}
				flag = -1;
				count = 1;
			}
			
			if(count==1) {
				
				r2--;
				if(k>=1) {
					
					while(k>0) {
						
						System.out.println(r2);
						k--;
						r2--;
					}
					flag = -1;
				}
			}
			else {
				
				if(k>=1) {
					
					while(k>=0) {
						
						System.out.println(r2);
						k--;
						r2--;
					}
					flag = -1;
				}
			}
			if(flag==0) {
				
				System.out.println(result);
			}
		}
	}
}
