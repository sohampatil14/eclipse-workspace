package exp_3;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class QucikSort_Pivot_Random {

    static ThreadLocalRandom tlr = ThreadLocalRandom.current();

			static void quickSort(int a[], int low, int high) {
				int pi, p = tlr.nextInt(low,high+1);
				  if (low < high) {
					
					  if(p==low) {
						  pi = partition_low(a, low, high);
					  }
					  else if(p==high) {
						  pi = partition_high(a, low, high);
					  }
					  else {
						  pi = partition(a, low, high, p);
					  }
					  quickSort(a, low, pi-1);
					  quickSort(a, pi + 1, high);
				  }
				  
			}
			
			 static int partition_high(int a[], int l, int h) {
			     int pivot = a[h];
			     int i=l; 
			     int j=h-1;

			     while(i<j){
			        

			         
			         while(a[i]<=pivot) {
			        	 i++;
			         }
			         
			         
			         while(a[j]>pivot) {
			        	 j--;
			         }

			         if(i<=j) {
			        	 
			             int tmp = a[j];
			             a[j] = a[i];
			             a[i] = tmp;
			         }
			         
			      
			     }

			 
			     int temp = a[h];
			     a[h] = a[i];
			     a[i] = temp;
			     return i;
			 }
			
			 static int partition_low(int a[], int l, int h) {
			     int pivot = a[l];
			     int i=l+1; 
			     int j=h;

			     while(i<j){
			        

			         
			         while(a[j]>pivot) {
			        	 j--;
			         }
			         
			         
			         while(i<=j && a[i]<=pivot) {
			        	 i++;
			         }

			         if(i<=j) {
			             int tmp = a[j];
			             a[j] = a[i];
			             a[i] = tmp;
			         }
			         
			         
			         
			     }

			 
			     int temp = a[l];
			     a[l] = a[j];
			     a[j] = temp;
			     return j;
			 }
			
			 static int partition(int a[], int l, int h, int p) {
			     int pivot = a[p];
			     int i=l; 
			     int j=h;

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
				    System.out.println("Unsorted Array");
			        System.out.println(java.util.Arrays.toString(data));

				    int size = data.length;
				    quickSort(data, 0, size - 1);
				    System.out.println("Sorted Array in Ascending Order ");
				    

			        System.out.println(java.util.Arrays.toString(data));
				    
				  }

	
}
