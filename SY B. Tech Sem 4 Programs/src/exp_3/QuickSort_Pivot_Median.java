package exp_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuickSort_Pivot_Median {

		
		static void quickSort(int a[], int low, int high) {
			int pi;
			  if (low < high) {
				
				  pi = partition(a, low, high);
				  quickSort(a, low, pi-1);
				  quickSort(a, pi + 1, high);
			  }
			  
		}
		
		 static int partition(int a[], int l, int h) {
		     int pivot = a[median(l,h)];
		     int i=l; 
		     int j=h;
		     System.out.print("Sub-array before sorting : ");
				for(int control=l;control<=h;control++) {
					
					System.out.print(a[control]+" ");
				}
				int count;
				if((h-l)>5) {
					count = 2;
				}
				else if((h-l)==4) {
					count = 3;
				}
				else {
					count = 4;
				}
				for(int control=0;control<count;control++) {
					
					System.out.print('\t');
				}
				System.out.print("Range : "+l+" to : "+h+'\t');
				System.out.print('\t');
				System.out.print("Pivot : "+pivot+'\n');
				System.out.println();
		     while(i<j){
		        

		         
		         while(a[i]<pivot) {
		        	 i++;
		         }
		         
		         
		         while(i<=j && a[j]>pivot) {
		        	 j--;
		         }

		         if(i<=j) {
		             int tmp = a[j];
		             a[j] = a[i];
		             a[i] = tmp;
		         }
		         
		         
		         
		     }
		     	
		   //Printing each recursion
		     
		     System.out.print("Sub-array after sorting : "+'\n');
				for(int control=l;control<=h;control++) {
					
					System.out.print(a[control]+" ");
				}
				System.out.println();
		     
		     return j;
		 }
		 
		 static int median(int l, int h) {
			 return (l+h)/2;
		 }
		 
		  public static void main(String args[]) {

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
			    quickSort(data, 0, size - 1);
			    System.out.println();
			    System.out.println("Sorted Array in Ascending Order ");
			    System.out.println();
			    System.out.println(java.util.Arrays.toString(data));
			    
			  }

}
