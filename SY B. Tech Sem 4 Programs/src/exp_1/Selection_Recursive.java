package exp_1;
import java.util.InputMismatchException;
import java.util.Scanner;

class Selection_Recursive {
	
    static void print(int arr[]) {
        
        for (int i=0; i<arr.length; ++i) {
        	
        	System.out.print(arr[i]+" ");
        }
        System.out.println();
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
        if(index==(n-1)) {
        	
        	System.out.print("Sorted array : ");
        	print(arr);
        }
        else {
        	
        	System.out.print("Pass "+index+" : ");
        	print(arr);
        }
		selection_sort(arr, n, index+1);
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
		
		selection_sort(arr, arr.length, 0);
    }
}

