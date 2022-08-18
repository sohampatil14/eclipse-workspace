package exp_1;
import java.util.InputMismatchException;
import java.util.Scanner;

class Selection {
	
    static void print(int arr[]) {
        
        for (int i=0; i<arr.length; ++i) {
        	
        	System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static void selection_sort(int arr[]) {
    
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
			System.out.print("Pass "+i+" : ");
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
		selection_sort(arr);
        System.out.println("Sorted array");
        print(arr);
    }
}