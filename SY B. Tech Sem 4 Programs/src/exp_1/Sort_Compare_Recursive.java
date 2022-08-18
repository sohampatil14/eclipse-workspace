package exp_1;
import java.util.Random;
import java.util.Scanner;

public class Sort_Compare_Recursive {

	static void insertion_sort(int arr[], int n) {
		
        if (n<=1) {
        	
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
	}
	
    static int minIndex(int a[], int i, int j)
    {
        if (i==j) {
         
        	return i;
        }
        int k = minIndex(a, i + 1, j);
      
        if(a[i]<a[k]) {
        	
        	return i;
        }
        else {
        	return k;
        }
    }
	
    static void selection_sort(int arr[], int n, int index) {
        
        int k;
    	if (index==n) {
         
    		return;
    	}
    	
        k = minIndex(arr, index, n-1);
        if (k!=index) {

        	int temp = arr[k];
        	arr[k] = arr[index];
        	arr[index] = temp;
        }
		selection_sort(arr, n, index+1);
    }
    
	public static void main(String args[]) {
		
		int arr[];
		System.out.print("Enter the number of elements for sorting : ");
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		arr = new int[s.nextInt()];
		for(int i=0;i<arr.length;i++) {
			
			arr[i] = r.nextInt(100000000);
		}
		
		long start = System.nanoTime();
		insertion_sort(arr, arr.length);
		long end = System.nanoTime();
		System.out.println("Time taken by Insertion sort for "+arr.length+" input is : " + (end - start) + " nanoseconds.");
		
		start = System.nanoTime();
		selection_sort(arr, arr.length, 0);
		end = System.nanoTime();
		System.out.println("Time taken by Selection sort for "+arr.length+" input is : " + (end - start) + " nanoseconds.");
	}
}
